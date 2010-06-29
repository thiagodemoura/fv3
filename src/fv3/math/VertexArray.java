/*
 * fv3.math
 * Copyright (c) 2009 John Pritchard, all rights reserved.
 *     
 * This program is free  software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 * 
 * This program  is  distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU Lesser General Public License for more details.
 * 
 * You should  have received a copy of the GNU Lesser General Public License
 * along with  this program; If not, see <http://www.gnu.org/licenses/>. 
 */
package fv3.math;

import java.nio.DoubleBuffer;

import javax.media.opengl.GL2;

/**
 * An (X,Y,Z) vertices buffer with tools.  
 * 
 * The vertices and normals buffers may be resized using the
 * "countVertices" method.  This operation expands or contracts the
 * vertics and normals buffers, preserving information.
 * 
 * @see Abstract
 * @author jdp
 */
public class VertexArray
    extends Abstract
    implements fv3.Model.Element
{
    public enum Type {
        Points, Lines, LineStrip, LineLoop, Triangles, TriangleStrip, TriangleFan, Quads, QuadStrip, Polygon;


        public final static Type For(int index){
            switch (index){
            case 0:
                return Points;
            case 1:
                return Lines;
            case 2:
                return LineStrip;
            case 3:
                return LineLoop;
            case 4:
                return Triangles;
            case 5:
                return TriangleStrip;
            case 6:
                return TriangleFan;
            case 7:
                return Quads;
            case 8:
                return QuadStrip;
            case 9:
                return Polygon;
            default:
                throw new IllegalArgumentException(String.valueOf(index));
            }
        }

        public boolean hasFaces(){
            switch(this){
            case Points:
            case Lines:
            case LineStrip:
            case LineLoop:
                return false;
            case Triangles:
            case TriangleStrip:
            case TriangleFan:
            case Quads:
            case QuadStrip:
                return true;
            case Polygon:
                return true;
            default:
                throw new IllegalStateException();
            }
        }
    }

    public final Type type;

    protected volatile int countVertices;

    protected volatile double[] vertices;

    protected volatile int countFaces;

    protected volatile double[] normals;

    protected volatile DoubleBuffer n;

    protected volatile boolean visible = true, useNormals;


    /**
     * @param count Number of verteces in this triangle strip
     */
    public VertexArray(int count){
        this(null,count);
    }
    /**
     * @param type Use of verteces as for calculating normals
     * @param count Number of verteces in this list.
     */
    public VertexArray(Type type, int count){
        super();
        if (null == type)
            this.type = Type.TriangleStrip;
        else
            this.type = type;

        this.countVertices = count;
        this.vertices = new double[3 * count];

        this.countFaces = CountFaces(this.type,count);
        if (0 != this.countFaces)
            this.normals = new double[3 * this.countFaces];
    }
    public VertexArray(Type type, VertexArray src){
        super();

        if (null == type)
            this.type = Type.TriangleStrip;
        else
            this.type = type;

        this.vertices = src.vertices(this.type);
        this.countVertices = (this.vertices.length / 3);

        this.countFaces = CountFaces(this.type,this.countVertices);
        if (0 < this.countFaces){
            this.normals = new double[3 * this.countFaces];
            this.computeNormals();
        }
    }


    public int[] ables(){

        if (this.visible){

            switch(this.type){
            case Points:
            case Lines:
            case LineStrip:
            case LineLoop:

                return new int[]{GL2.GL_VERTEX_ARRAY};

            case Triangles:
            case TriangleStrip:
            case TriangleFan:
            case Quads:
            case QuadStrip:
            case Polygon:

                if (this.useNormals){

                    return new int[]{GL2.GL_NORMAL_ARRAY,
                                     GL2.GL_VERTEX_ARRAY};
                }
                else {
                    return new int[]{GL2.GL_VERTEX_ARRAY};
                }
            default:
                throw new IllegalStateException();
            }
        }
        else
            return null;
    }
    public void define(GL2 gl){

        if (this.visible){

            /*
             * These calls provide data for compilation into the display
             * list
             */
            gl.glVertexPointer(3,GL2.GL_DOUBLE,0,this.buffer());

            if (this.useNormals)
                gl.glNormalPointer(GL2.GL_DOUBLE,0,this.normalsBuffer());

            /*
             * These calls are compiled into the display list
             */
            switch(this.type){
            case Points:
                gl.glDrawArrays(GL2.GL_POINTS,0,this.countVertices);
                return;
            case Lines:
                gl.glDrawArrays(GL2.GL_LINES,0,this.countVertices);
                return;
            case LineStrip:
                gl.glDrawArrays(GL2.GL_LINE_STRIP,0,this.countVertices);
                return;
            case LineLoop:
                gl.glDrawArrays(GL2.GL_LINE_LOOP,0,this.countVertices);
                return;
            case Triangles:
                gl.glDrawArrays(GL2.GL_TRIANGLES,0,this.countVertices);
                return;
            case TriangleStrip:
                gl.glDrawArrays(GL2.GL_TRIANGLE_STRIP,0,this.countVertices);
                return;
            case TriangleFan:
                gl.glDrawArrays(GL2.GL_TRIANGLE_FAN,0,this.countVertices);
                return;
            case Quads:
                gl.glDrawArrays(GL2.GL_QUADS,0,this.countVertices);
                return;
            case QuadStrip:
                gl.glDrawArrays(GL2.GL_QUAD_STRIP,0,this.countVertices);
                return;
            case Polygon:
                gl.glDrawArrays(GL2.GL_POLYGON,0,this.countVertices);
                return;
            default:
                throw new IllegalStateException();
            }
        }
    }
    public final int countVertex(){
        return this.countVertices;
    }
    /**
     * Redefine the buffer size, preserving data.
     * @param count Number of vertices
     */
    public final VertexArray countVertices(int count){
        if (1 > count)
            throw new IllegalArgumentException(String.valueOf(count));

        else {
            if (count != this.countVertices){

                {
                    int many = Math.min(count,this.countVertices);
                    double[] vertices = new double[3 * count];
                    System.arraycopy(this.vertices,0,vertices,0,many);
                    this.vertices = vertices;
                    super.b = null;
                }
                this.countVertices = count;

                switch(this.type){
                case Points:
                case Lines:
                case LineStrip:
                case LineLoop:
                    this.countFaces = 0;
                    this.normals = null;
                    break;
                case Triangles:
                    this.countFaces = (count/3);
                    break;
                case TriangleStrip:
                    this.countFaces = (count-2);
                    break;
                case TriangleFan:
                    this.countFaces = (count-2);
                    break;
                case Quads:
                    this.countFaces = (count/4);
                    break;
                case QuadStrip:
                    this.countFaces = (count/2)-1;
                    break;
                case Polygon:
                    this.countFaces = 1;
                    break;
                default:
                    throw new IllegalStateException();
                }
                if (null != this.normals){
                    int many = Math.min(this.normals.length,this.countFaces);
                    double[] normals = new double[3 * this.countFaces];
                    System.arraycopy(this.normals,0,normals,0,many);
                    this.normals = normals;
                    this.n = null;
                }
            }
            return this;
        }
    }
    /**
     * @param index Vertex index
     * @return Copy of the three values in the referenced vertex.
     */
    public final double[] getVertex(int index){

        return this.copyVertex(index,(new double[3]),0);
    }
    public final double[] copyVertex(int index, double[] re, int ofs){

        final int start = (3 * index);

        System.arraycopy(this.vertices,start,re,ofs,3);
        return re;
    }
    /**
     * @param index Vertex index
     * @param vertex Array of three values to copy into the referenced vertex.
     * @return This
     */
    public final VertexArray setVertex(int index, double[] vertex){

        final int start = (3 * index);

        System.arraycopy(vertex,0,this.vertices,start,3);
        return this;
    }
    public final VertexArray setVertex(int index, double x, double y, double z){

        final int X = (3 * index);
        final int Y = (X + 1);
        final int Z = (Y + 1);

        this.vertices[X] = x;
        this.vertices[Y] = y;
        this.vertices[Z]   = z;

        return this;
    }
    /**
     * @param index Vertex index
     * @param vertex Array of three values to copy into the referenced vertex.
     * @param ofs Offset into vertex array 
     * @return This
     */
    public final VertexArray setVertex(int index, double[] vertex, int ofs){

        final int start = (3 * index);

        System.arraycopy(vertex,ofs,this.vertices,start,3);
        return this;
    }
    /**
     * @param index Vertex index
     * @param vertex Array of three values to copy into the referenced vertex.
     * @param ofs Offset into vertex array 
     * @param count Number of vertices from vertex array to copy into
     * <code>(index, index+1, ..., index+count-1)</code>
     * @return This
     */
    public final VertexArray setVertices(int index, double[] vertex, int ofs, int count){

        final int start = (3 * index);
        final int many = (3 * count);

        System.arraycopy(vertex,ofs,this.vertices,start,many);
        return this;
    }
    public final double[] array(){
        return this.vertices;
    }
    public final int countFaces(){
        return this.countFaces;
    }
    /**
     * Array
     */
    public final double[] getFace(int face){
        int[] vertices = this.faceIndeces(face);

        int n = (3 * vertices.length);

        double[] faceV = new double[n];

        for (int x = 0, z = vertices.length; x < z; x++){

            this.copyVertex(vertices[x],faceV,(3*x));
        }
        return faceV;
    }
    public final int countNormal(){
        return this.countFaces;
    }
    /**
     * @param index Normal index
     * @return Copy of the three values in the referenced normal.
     */
    public final double[] getNormal(int index){

        return this.copyNormal(index,(new double[3]),0);
    }
    public final double[] copyNormal(int index, double[] re, int ofs){

        int start = (3 * index);
        System.arraycopy(this.normals,start,re,ofs,3);
        return re;
    }
    /**
     * @param index Normal index
     * @param vector Array of three values to copy into the referenced vector.
     * @return This
     */
    public final VertexArray setNormal(int index, double[] vector){
        this.useNormals = true;

        int start = (3 * index);
        System.arraycopy(vector,0,this.normals,start,3);
        return this;
    }
    /**
     * Compute a normal for a face.
     * @param face Index from zero into faces.
     */
    public final VertexArray computeNormal(int face){
        this.useNormals = true;

        int[] vertices = this.faceIndeces(face);
        if (3 > vertices.length)
            throw new IllegalStateException(this.type.toString());
        else {
            Vector va = new Vector(this.getVertex(vertices[0]));
            Vector vb = new Vector(this.getVertex(vertices[1]));
            Vector vc = new Vector(this.getVertex(vertices[2]));
            Vector normal = va.normal(vb,vc);
            return this.setNormal(face,normal.array());
        }
    }
    public final VertexArray computeNormals(){

        switch(this.type){
        case Points:
        case Lines:
        case LineStrip:
        case LineLoop:

            this.useNormals = false;
            return this;

        case Triangles:
        case TriangleStrip:
        case TriangleFan:
        case Quads:
        case QuadStrip:

            this.useNormals = true;

            for (int face = 0, count = this.countFaces; face < count; face++){

                int[] vertices = this.faceIndeces(face);

                Vector va = new Vector(this.getVertex(vertices[0]));
                Vector vb = new Vector(this.getVertex(vertices[1]));
                Vector vc = new Vector(this.getVertex(vertices[2]));

                Vector normal = va.normal(vb,vc);

                System.arraycopy(normal.array(),0,this.normals,(3*face),3);
            }
            return this;

        case Polygon:
            return this.computeNormal(0);

        default:
            throw new IllegalStateException();
        }
    }
    public final double[] normals(){
        return this.normals;
    }
    public DoubleBuffer normalsBuffer(){
        DoubleBuffer n = this.n;
        if (null == n){
            double[] a = this.normals();
            if (null != a){
                n = DoubleBuffer.wrap(a);
                this.n = n;
            }
            else
                return null;
        }
        return n;
    }
    /**
     * Indeces for features composed of vertices, i.e. "face" extended
     * to all types including points and lines.
     * @param face Index counting from zero
     * @return Indeces for verteces in this face
     */
    public final int[] faceIndeces(int face){
        return FaceIndeces(this.type,face);
    }
    public double[] vertices(Type thatType){
        if (null == thatType)
            throw new IllegalArgumentException();

        else if (thatType == this.type)
            return this.array();

        else if (this.type.hasFaces() && thatType.hasFaces()){

            final int thatCountVertices = CountVertices(thatType,this.type,this.countVertices);

            double[] thatVertices = new double[3 * thatCountVertices];
            
            for (int face = 0, count = this.countFaces; face < count; face++){

                double[] thisFace = this.getFace(face);

                switch(this.type){

                case Triangles:

                    switch(thatType){

                    case TriangleFan:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));

                    case TriangleStrip:{
                        int[] next = FaceIndeces(thatType,face);
                        if (0 == face){
                            
                            SetVertex(next[0], thisFace, 0, thatVertices);
                            SetVertex(next[1], thisFace, 3, thatVertices);
                            SetVertex(next[2], thisFace, 6, thatVertices);
                        }
                        else {
                            int[] prev = FaceIndeces(thatType,(face-1));

                            if (StripMatch(next,prev)){

                                SetVertex(next[0], thisFace, 0, thatVertices);
                                SetVertex(next[1], thisFace, 3, thatVertices);
                                SetVertex(next[2], thisFace, 6, thatVertices);
                            }
                            else {
                                /*
                                 * Maybe this is a perspective to
                                 * start from for looking into
                                 * http://steve.hollasch.net/cgindex/geometry/gridmesh.c
                                 */
                                throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                            }
                        }
                        break;
                    }
                    case Quads:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case QuadStrip:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case Polygon:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    default:
                        throw new IllegalStateException();
                    }
                    break;

                case TriangleStrip:

                    switch(thatType){

                    case Triangles:{

                        int[] next = FaceIndeces(thatType,face);
                        SetVertex(next[0], thisFace, 0, thatVertices);
                        SetVertex(next[1], thisFace, 3, thatVertices);
                        SetVertex(next[2], thisFace, 6, thatVertices);
                        break;
                    }
                    case TriangleFan:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));

                    case Quads:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case QuadStrip:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case Polygon:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    default:
                        throw new IllegalStateException();
                    }
                    break;


                case TriangleFan:

                    switch(thatType){

                    case Triangles:{

                        int[] indeces = FaceIndeces(thatType,face);
                        SetVertex(indeces[0], thisFace, 0, thatVertices);
                        SetVertex(indeces[1], thisFace, 3, thatVertices);
                        SetVertex(indeces[2], thisFace, 6, thatVertices);
                        break;
                    }
                    case TriangleStrip:{

                        int[] indeces = FaceIndeces(thatType,face);
                        SetVertex(indeces[0], thisFace, 0, thatVertices);
                        SetVertex(indeces[1], thisFace, 3, thatVertices);
                        SetVertex(indeces[2], thisFace, 6, thatVertices);
                        break;
                    }
                    case Quads:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case QuadStrip:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case Polygon:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    default:
                        throw new IllegalStateException();
                    }
                    break;


                case Quads:

                    switch(thatType){

                    case Triangles:{

                        final int thatFaceA = (2 * face);
                        final int thatFaceB = (thatFaceA + 1);

                        int[] indeces;

                        indeces = FaceIndeces(thatType,thatFaceA);
                        SetVertex(indeces[0], thisFace, 0, thatVertices);
                        SetVertex(indeces[1], thisFace, 3, thatVertices);
                        SetVertex(indeces[2], thisFace, 9, thatVertices);

                        indeces = FaceIndeces(thatType,thatFaceB);
                        SetVertex(indeces[0], thisFace, 3, thatVertices);
                        SetVertex(indeces[1], thisFace, 6, thatVertices);
                        SetVertex(indeces[2], thisFace, 9, thatVertices);
                        break;
                    }
                    case TriangleStrip:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case TriangleFan:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case QuadStrip:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case Polygon:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    default:
                        throw new IllegalStateException();
                    }
                    break;


                case QuadStrip:

                    switch(thatType){

                    case Triangles:{

                        final int thatFaceA = (2 * face);
                        final int thatFaceB = (thatFaceA + 1);

                        int[] indeces;

                        indeces = FaceIndeces(thatType,thatFaceA);
                        SetVertex(indeces[0], thisFace, 0, thatVertices);
                        SetVertex(indeces[1], thisFace, 3, thatVertices);
                        SetVertex(indeces[2], thisFace, 9, thatVertices);

                        indeces = FaceIndeces(thatType,thatFaceB);
                        SetVertex(indeces[0], thisFace, 3, thatVertices);
                        SetVertex(indeces[1], thisFace, 6, thatVertices);
                        SetVertex(indeces[2], thisFace, 9, thatVertices);
                        break;
                    }
                    case TriangleStrip:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case TriangleFan:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));

                    case Quads:{

                        int[] indeces = FaceIndeces(thatType,face);
                        SetVertex(indeces[0], thisFace, 0, thatVertices);
                        SetVertex(indeces[1], thisFace, 3, thatVertices);
                        SetVertex(indeces[2], thisFace, 6, thatVertices);
                        SetVertex(indeces[3], thisFace, 9, thatVertices);
                        break;
                    }
                    case Polygon:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    default:
                        throw new IllegalStateException();
                    }
                    break;


                case Polygon:

                    switch(thatType){

                    case Triangles:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case TriangleStrip:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case TriangleFan:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case Quads:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    case QuadStrip:
                        throw new UnsupportedOperationException(String.format("From %s To %s",this.type,thatType));
                    default:
                        throw new IllegalStateException();
                    }
                    //break;

                default:
                    throw new IllegalStateException();
                }
            }
            return thatVertices;
        }
        else
            throw new IllegalStateException("[TODO] additional conversions");
    }

    public final static int CountVertices(Type to, Type from, int fromCountVertices){
        if (to == from)
            return fromCountVertices;
        else {
            int fromCountFaces = CountFaces(from,fromCountVertices);

            switch(from){

            case Triangles:
            case TriangleStrip:
            case TriangleFan:

                switch(to){

                case Triangles:
                case TriangleStrip:
                case TriangleFan:
                    return CountVertices(to,fromCountFaces);

                case Quads:
                case QuadStrip:
                    return CountVertices(to,(fromCountFaces>>1));

                case Polygon:
                default:
                    throw new IllegalStateException();
                }
                //break;

            case Quads:
            case QuadStrip:

                switch(to){

                case Triangles:
                case TriangleStrip:
                case TriangleFan:
                    return CountVertices(to,(fromCountFaces<<1));

                case Quads:
                case QuadStrip:
                    return CountVertices(to,fromCountFaces);

                case Polygon:
                default:
                    throw new IllegalStateException();
                }
                //break;

            case Polygon:
            default:
                throw new IllegalStateException();
            }
        }
    }
    public final static int CountNormals(Type to, Type from, int fromCountFaces){
        if (to == from)
            return fromCountFaces;
        else {
            int fromCountVertices = CountVertices(from,fromCountFaces);
            return CountFaces(to,fromCountVertices);
        }
    }
    public final static int CountVertices(Type to, int countFaces){
        switch(to){

        case Triangles:
            return (3 * countFaces);

        case TriangleStrip:
            return (countFaces+2);

        case TriangleFan:
            return (countFaces+2);

        case Quads:
            return (4 * countFaces);

        case QuadStrip:
            return (2 * (countFaces+1));

        case Polygon:
            return 1;

        default:
            throw new IllegalStateException();
        }
    }
    public final static int CountFaces(Type to, int countVertices){
        switch(to){
        case Points:
        case Lines:
        case LineStrip:
        case LineLoop:
            return 0;

        case Triangles:
            return (countVertices/3);

        case TriangleStrip:
            return (countVertices-2);

        case TriangleFan:
            return (countVertices-2);

        case Quads:
            return (countVertices/4);

        case QuadStrip:
            return (countVertices/2)-1;

        case Polygon:
            return 1;

        default:
            throw new IllegalStateException();
        }
    }
    public final static int[] FaceIndeces(Type type, int face){
        switch(type){
        case Points:
            return new int[]{face};
        case Lines:{
            int a = (2 * face);
            int b = (a + 1);

            return new int[]{a,b};
        }
        case LineStrip:{
            int a = (face);
            int b = (a + 1);

            return new int[]{a,b};
        }
        case LineLoop:{
            int a = (face);
            int b = (a + 1);

            return new int[]{a,b};
        }
        case Triangles:{

            int n = (3 * face);
            int a = (n);
            int b = (n + 1);
            int c = (n + 2);

            return new int[]{a,b,c};
        }
        case TriangleStrip:{
            int a, b, c;
            int n = face;
            if (1 == (n&1)){
                a = (n);
                b = (n + 1);
                c = (n + 2);
            }
            else {
                a = (n + 1);
                b = (n);
                c = (n + 2);
            }
            return new int[]{a,b,c};
        }
        case TriangleFan:{

            int n = face;
            int a = (0);
            int b = (n + 1);
            int c = (n + 2);

            return new int[]{a,b,c};
        }
        case Quads:{

            int n = (4 * face);
            int a = (n);
            int b = (n + 1);
            int c = (n + 2);
            int d = (n + 3);

            return new int[]{a,b,c,d};
        }
        case QuadStrip:{

            int n = (2 * face);
            int a = (n);
            int b = (n + 1);
            int c = (n + 3);
            int d = (n + 2);

            return new int[]{a,b,c,d};
        }
        case Polygon:{
            int n = (face);
            int[] v = new int[n];
            for (int x = 0; x < n; x++)
                v[x] = x;
            return v;
        }
        default:
            throw new IllegalStateException();
        }
    }
    public final static void SetVertex(int index, double[] vertex, int ofs, double[] vertices){

        final int start = (3 * index);

        System.arraycopy(vertex,ofs,vertices,start,3);
    }
    public final static boolean StripMatch(int[] thisIndeces, int[] thatIndeces)
    {
        if (thisIndeces.length == thatIndeces.length){
            for (int i = 0, c = -1, j, z = thisIndeces.length; i < z; i++){

                int ii = thisIndeces[i];

                for (j = 0; j < z; j++){

                    int jj = thatIndeces[j];

                    if (ii == jj){

                        if (-1 != c)

                            return (i == (c+1));
                        else
                            c = i;
                    }
                }
            }
            return false;
        }
        else
            throw new IllegalArgumentException(String.format("%d != %d",thisIndeces.length,thatIndeces.length));
    }
}
