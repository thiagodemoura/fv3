/*
 * fv3
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
package fv3.font;

/**
 * The general strategy is that applications embed fonts; fonts are
 * scaled and rendered for size and resolution.  Following the Fv3
 * model, whether this happens at run time or design time is a
 * variable.
 * 
 * 
 * @author John Pritchard
 */
public class Font
    extends Object
    implements Cloneable
{

    private final String name;

    private final FontOptions options;

    private Glyph[] list;


    public Font(String name, FontReader reader) {
        this(name,reader,(new FontOptions()));
    }
    public Font(String name, FontReader reader, FontOptions opts) {
        super();
        if (null != name && null != reader && null != opts){
            this.name = Clean(name);
            this.options = opts;
        }
        else
            throw new IllegalArgumentException();
    }


    public final boolean alive(){
        return (null != this.list);
    }
    public void destroy(){
        Glyph[] glyphs = this.list;
        if (null != glyphs){
            this.list = null;
            for (Glyph gly : glyphs){
                gly.destroy();
            }
        }
    }
    public final String getName(){
        return this.name;
    }
    public final FontOptions getOptions(){
        return this.options;
    }
    public final int getLength(){
        Glyph[] list = this.list;
        if (null == list)
            return 0;
        else
            return list.length;
    }
    public final Glyph get(int idx){
        Glyph[] list = this.list;
        if (null == list)
            throw new ArrayIndexOutOfBoundsException(String.valueOf(idx));

        else if (-1 < idx && idx < list.length)
            return list[idx];
        else
            throw new ArrayIndexOutOfBoundsException(String.valueOf(idx));
    }
    protected final Font add(Glyph glyph){
        if (null != glyph){

            glyph.init(this.options);

            Glyph[] list = this.list;
            if (null == list)
                this.list = new Glyph[]{glyph};
            else {
                int len = list.length;
                Glyph[] copier = new Glyph[len+1];
                System.arraycopy(list,0,copier,0,len);
                copier[len] = glyph;
                this.list = copier;
            }
        }
        return this;
    }
    public Font clone(){
        try {
            return (Font)super.clone();
        }
        catch (CloneNotSupportedException exc){
            throw new InternalError();
        }
    }
    public int hashCode() {
        return (this.name.hashCode() ^ this.options.hashCode());
    }
    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (!(o instanceof Font))
            return false;
        else 
            return (((Font)o).name.equals(name));
    }
    private final static String Clean(String name){
        if (null != name){
            int idx = name.lastIndexOf('.');
            if (-1 != idx)
                name = name.substring(0,idx);
        }
        return name;
    }
}
