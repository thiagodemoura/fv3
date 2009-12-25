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
package fv3.font.cff;

/**
 * DisplayOptions for each glyph.
 * You'll need to use this class if using the renderer...
 * @author Tim Tyler
 * @author John Pritchard
 */
public class DisplayOptions
    implements Cloneable, DisplayOptionsConstants
{

    private boolean hint = true;
    private boolean fill = true;
    private int slant; // 0
    private int expand; // 1024
    private Pen pen = new PenRound(0x300);
    private Coords coords;


    public DisplayOptions(int slant, int expand, boolean hint, boolean fill, Pen pen, Coords coords) {
        super();
        set(slant, expand, hint, fill, pen, coords);
    }

    public DisplayOptions() {
        super();
        set(DEFAULT_SLANT, DEFAULT_EXPAND, DEFAULT_HINT, DEFAULT_FILL, DEFAULT_PEN, DEFAULT_COORDS);
    }

    private void set(int slant, int expand, boolean hint, boolean fill, Pen pen, Coords coords) {
        this.slant = slant;
        this.expand = expand;
        this.hint = hint;
        this.fill = fill;
        this.pen = pen;
        this.coords = coords;
    }

    public static DisplayOptions getGDOForScaling() {
        return new DisplayOptions(DEFAULT_SLANT, DEFAULT_EXPAND, false, DEFAULT_FILL, DisplayOptionsConstants.DEFAULT_PEN, DEFAULT_COORDS);
    }

    private static DisplayOptions getGDOdefaults() {
        return new DisplayOptions(DEFAULT_SLANT, DEFAULT_EXPAND, DEFAULT_HINT, DEFAULT_FILL, DisplayOptionsConstants.DEFAULT_PEN, DEFAULT_COORDS);
    }

    public static DisplayOptions getGDOrender(int siz, int aa_sf_x, int aa_sf_y, Pen pen, boolean filled) {
        Coords c = new Coords((siz >> 1) * aa_sf_x, siz * aa_sf_y, siz >> 1, siz);

        return new DisplayOptions(DEFAULT_SLANT, DEFAULT_EXPAND, true, filled, pen, c);
    }

    public int getLineWidthOffsetEast() {
        return 0 - (coords.getOnePixelWidth() >> 1) + pen.getRight();
    }

    public int getLineWidthOffsetWest() {
        return 0 - (coords.getOnePixelWidth() >> 2) - pen.getLeft();
    }

    public int getLineWidthOffsetNorth() {
        return 0 - (coords.getOnePixelHeight() >> 2) - pen.getTop();
    }

    public int getLineWidthOffsetSouth() {
        return 0 - (coords.getOnePixelHeight() >> 1) + pen.getBottom();
    }

    public Coords getCoords() {
        return coords;
    }

    public boolean isFill() {
        return fill;
    }

    public boolean isHint() {
        return hint;
    }

    public Object clone() throws CloneNotSupportedException {
        return new DisplayOptions(slant, expand, hint, fill, pen, (Coords) coords.clone());
    }

    public void refresh() {
        coords.refresh();
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public void setHint(boolean hint) {
        this.hint = hint;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public Pen getPen() {
        return pen;
    }

    public boolean isShowGrid() { // no associated grid here...
        return false;
    }

    public boolean isBorder() { // no associated border here...
        return false;
    }
  
    public boolean isShowPoints() { // don't show points here...
        return false;
    }
  
    public boolean isShowSliders() { // no associated sliders visible here...
        return false;
    }
  
    public boolean isShowSprings() { // no associated springs visible here...
        return false;
    }
  
    public boolean isTruncate() {
        return true;
    }
  
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof DisplayOptions)) {
            return false;
        }

        DisplayOptions gdo = (DisplayOptions) o;

        if (gdo.hashCode() != hashCode()) {
            return false;
        }
    
        if (gdo.slant != slant) {
            return false;
        }

        if (gdo.expand != expand) {
            return false;
        }

        if (gdo.hint != hint) {
            return false;
        }

        if (gdo.fill != fill) {
            return false;
        }

        if (!gdo.pen.equals(pen)) {
            return false;
        }

        return gdo.coords.equals(coords);
    }

    public int hashCode() {
        int hash_code = 0;
        hash_code ^= slant + slant << 17;
        hash_code ^= expand + expand << 11;
        hash_code ^= hint ? 0x19754368 : 0x3974B3E4;
        hash_code ^= fill ? 0xC76D1425 : 0xE1637568;
        hash_code ^= pen.hashCode();
        hash_code ^= coords.hashCode();
        return hash_code;
    }

    public void setSlant(int slant) {
        this.slant = slant;
    }

    public int getSlant() {
        return slant;
    }

    public void setExpand(int expand) {
        this.expand = expand;
    }

    public int getExpand() {
        return expand;
    }

}
