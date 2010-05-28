/*
 * Fv3
 * Copyright (C) 2009  John Pritchard, jdp@syntelos.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fv3;

import fv3.tk.Animator;

import java.io.IOException;

import java.net.URL;

import javax.media.opengl.GL2;

/**
 * The world of the screen may contain many regions and components
 * having many coordinate spaces -- all visible simultaneously without
 * pages or tabs -- as a single application, or a practical workspace.
 * 
 * A component is added to the world of the screen with the "load"
 * function.  Or, a new view is created from a component with the
 * "clear and load" function.
 * 
 * The methods defined here will not interfere with the normal
 * operation of an instance of this class as a normal {@link Region}.
 * 
 * @author jdp
 */
public class World
    extends fv3.nui.Region
{
    /**
     * @see #load(java.net.URL)
     * @see #clear()
     */
    public static Component ClearAndLoad(URL jnlp) throws IOException {
        Window.clear();
        return Window.load(jnlp);
    }
    /**
     * @see #load(java.net.URL)
     */
    public static Component Load(URL jnlp) throws IOException {
        return Window.load(jnlp);
    }
    /**
     * @see #unload(java.net.URL)
     */
    public static Component Unload(URL jnlp) throws IOException {
        return Window.unload(jnlp);
    }
    /**
     * Current focus of input events.
     * @see Region
     */
    public static Component Current(){
        return Window.getCurrent();
    }
    /**
     * @see Region
     */
    public static void Current(Component c){
        Window.setCurrent(c);
    }


    private volatile static World Window;
    /*
     * Main subclasses do the same..
     */
    public static void main(String[] argv){
        try {
            World window = new World();
            Animator animator = new Animator(window);
            animator.start();
        }
        catch (Exception exc){
            exc.printStackTrace();
            System.exit(1);
        }
    }


    private volatile Camera[] cameras = new Camera[26];

    private volatile int cameraCurrent;


    protected World(){
        super();
        if (null == Window)
            Window = this;

        this.useCamera('A');
    }


    public Camera getCamera(){
        return this.cameras[this.cameraCurrent];
    }
    public void useCamera(char name){
        if ('A' <= name && 'Z' >= name){

            int idx = name-'A';

            if (null == this.cameras[idx])
                this.cameras[idx] = new Camera(name);

            this.cameraCurrent = idx;
        }
        else if ('a' <= name && 'z' >= name){
            
            int idx = name-'a';

            if (null == this.cameras[idx])
                this.cameras[idx] = new Camera(name);

            this.cameraCurrent = idx;
        }
        else
            throw new IllegalArgumentException(String.format("0x%x",(int)name));
    }
    public void defineCamera(Camera camera){

        this.cameras[camera.index] = camera;
    }
    public void useCamera(Camera camera){

        this.cameras[camera.index] = camera;
        this.cameraCurrent = camera.index;
    }

    public void display(GL2 gl){

        this.camera(gl);
    }
    protected void cameraNone(GL2 gl){

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        super.display(gl);
    }
    protected void camera(GL2 gl){

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        Camera camera = this.getCamera();
        camera.apply(gl,this.glu);

        super.display(gl);
    }
    /**
     * Unload current components.
     */
    public void clear(){
        throw new UnsupportedOperationException("To be done");
    }
    /**
     * This function loads a JNLP descriptor using a {@link
     * loader.sandbox.WebLoader}.  
     * 
     * The JNLP descriptor has an application main class with a main
     * method that should do nothing.  
     * 
     * The JNLP application main class is an instance of {@link
     * Component}.
     * 
     * The returned component becomes a child of the world region
     * (this class).
     */
    public Component load(URL jnlp) throws IOException {
        throw new UnsupportedOperationException("To be done");
    }
    public Component unload(URL jnlp) throws IOException {
        throw new UnsupportedOperationException("To be done");
    }
}
