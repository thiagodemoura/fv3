/*
 * fv3
 * Copyright (C) 2010, John Pritchard, all rights reserved.
 * 
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package fv3.csg;

import fv3.math.Matrix;
import fv3.math.VertexArrayProfile;

/**
 * Rotate a convex solid centered on a known coordinate in the axis of
 * rotation.
 * 
 * The solid must be compiled into its vertex array (super class)
 * before rotation.
 * 
 * This works by selecting all points in the plane normal to the axis
 * of rotation at the plane coordinate within a plane epsilon.
 * 
 * Correctness depends on the desired rotation profile (exclusively)
 * lying in the plane coordinate within the plane epsilon.
 * 
 * @see fv3.math.VertexArrayProfile
 * @author John Pritchard
 */
public abstract class Rotation
    extends NonConvex
{
    public static class Z
        extends Rotation
    {
        public Z(double r, double e, Convex s){
            this(r,e,s,0.0);
        }
        public Z(double r, double e, Convex s, double pz){
            this(r,e,s,pz,EPSILON);
        }
        public Z(double r, double e, Convex s, double pz, double pe){
            super(r,e);
            if (null != s){
                VertexArrayProfile sp = s.profileXY(pz,pe);

                Vertex[][] t = this.list(sp);

                final int cn = sp.countVertices();

                for (int ru = 0, rv = 1; ru < this.rn; ru++, rv++){

                    if (rv == this.rn)
                        rv = 0;

                    for (int cu = 0, cv = 1; cu < cn; cu++, cv++){

                        if (cv == cn)
                            cv = 0;

                        Vertex qa = t[ru][cu];
                        Vertex qb = t[rv][cu];
                        Vertex qc = t[rv][cv];
                        Vertex qd = t[ru][cv];

                        this.add(qa,qb,qd);
                        this.add(qb,qc,qd);
                    }
                }
            }
            else
                throw new IllegalArgumentException();
        }

        protected Vertex[][] list(VertexArrayProfile sp){

            final int cn = sp.countVertices();

            Vertex[][] re = new Vertex[this.rn][cn];

            double ra = 0.0;

            for (int ru = 0; ru < this.rn; ru++){

                Matrix m = new Matrix().rotateZ(ra);

                Vertex[] rel = re[ru];

                for (int cu = 0; cu < cn; cu++){

                    rel[cu] = new Vertex(m.transform(sp.getVertex(cu)));
                }
                ra += this.rs;
            }
            return re;
        }
    }


    public final double radius;
    public final double error;
    protected final int rn;
    protected final double rs;

    protected Rotation(double r, double e){
        super(0);
        if (r == r && 0.0 < r){
            this.radius = r;
            if (e == e && 0.0 < e){
                this.error = e;
                /*
                 * Arc of rotation
                 */
                this.rn = Error.Circle.N(r,e);

                this.rs = (PI_M2 / (double)this.rn);
            }
            else
                throw new IllegalArgumentException();
        }
        else
            throw new IllegalArgumentException();
    }

}
