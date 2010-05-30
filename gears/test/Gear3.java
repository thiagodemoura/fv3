package test;

import fv3.math.AxisAngle;
import fv3.model.Begin ;
import fv3.model.End ;
import fv3.model.Material ;
import fv3.model.Model ;
import fv3.model.Normal ;
import fv3.model.ShadeModel ;
import fv3.model.Vertex ;

import javax.media.opengl.GL2;

/**
 * Blue gear
 */
public class Gear3
    extends fv3.model.Model
{

    private final static float MatBlue[] = { 0.2f, 0.2f, 1.0f, 1.0f };

    private final static fv3.model.Object[] MODEL3 = {
        new Material(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE, MatBlue),
        new ShadeModel(GL2.GL_FLAT),
        new Normal(  0.00000000000000000000000000,  0.00000000000000000000000000,  1.00000000000000000000000000),
        new Begin(GL2.GL_QUAD_STRIP),
        new Vertex(  1.29999995231628420000000000,  0.00000000000000000000000000,  0.25000000000000000000000000),
        new Vertex(  1.64999997615814200000000000,  0.00000000000000000000000000,  0.25000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000000000000000000000000,  0.25000000000000000000000000),
        new Vertex(  1.47016072273254400000000000,  0.74908435344696040000000000,  0.25000000000000000000000000),
        new Vertex(  1.05172204971313480000000000,  0.76412081718444820000000000,  0.25000000000000000000000000),
        new Vertex(  1.33487808704376220000000000,  0.96984565258026120000000000,  0.25000000000000000000000000),
        new Vertex(  1.05172204971313480000000000,  0.76412081718444820000000000,  0.25000000000000000000000000),
        new Vertex(  0.74908435344696040000000000,  1.47016072273254400000000000,  0.25000000000000000000000000),
        new Vertex(  0.40172204375267030000000000,  1.23637342453002930000000000,  0.25000000000000000000000000),
        new Vertex(  0.50987797975540160000000000,  1.56924331188201900000000000,  0.25000000000000000000000000),
        new Vertex(  0.40172204375267030000000000,  1.23637342453002930000000000,  0.25000000000000000000000000),
        new Vertex( -0.25811684131622314000000000,  1.62968575954437260000000000,  0.25000000000000000000000000),
        new Vertex( -0.40172213315963745000000000,  1.23637342453002930000000000,  0.25000000000000000000000000),
        new Vertex( -0.50987809896469120000000000,  1.56924319267272950000000000,  0.25000000000000000000000000),
        new Vertex( -0.40172213315963745000000000,  1.23637342453002930000000000,  0.25000000000000000000000000),
        new Vertex( -1.16672611236572270000000000,  1.16672611236572270000000000,  0.25000000000000000000000000),
        new Vertex( -1.05172216892242430000000000,  0.76412069797515870000000000,  0.25000000000000000000000000),
        new Vertex( -1.33487808704376220000000000,  0.96984553337097170000000000,  0.25000000000000000000000000),
        new Vertex( -1.05172216892242430000000000,  0.76412069797515870000000000,  0.25000000000000000000000000),
        new Vertex( -1.62968575954437260000000000,  0.25811684131622314000000000,  0.25000000000000000000000000),
        new Vertex( -1.29999995231628420000000000, -0.00000011364960528226220000,  0.25000000000000000000000000),
        new Vertex( -1.64999997615814200000000000, -0.00000014424757921460696000,  0.25000000000000000000000000),
        new Vertex( -1.29999995231628420000000000, -0.00000011364960528226220000,  0.25000000000000000000000000),
        new Vertex( -1.47016072273254400000000000, -0.74908441305160520000000000,  0.25000000000000000000000000),
        new Vertex( -1.05172193050384520000000000, -0.76412093639373780000000000,  0.25000000000000000000000000),
        new Vertex( -1.33487796783447270000000000, -0.96984583139419560000000000,  0.25000000000000000000000000),
        new Vertex( -1.05172193050384520000000000, -0.76412093639373780000000000,  0.25000000000000000000000000),
        new Vertex( -0.74908387660980220000000000, -1.47016096115112300000000000,  0.25000000000000000000000000),
        new Vertex( -0.40172162652015686000000000, -1.23637354373931880000000000,  0.25000000000000000000000000),
        new Vertex( -0.50987744331359860000000000, -1.56924331188201900000000000,  0.25000000000000000000000000),
        new Vertex( -0.40172162652015686000000000, -1.23637354373931880000000000,  0.25000000000000000000000000),
        new Vertex(  0.25811776518821716000000000, -1.62968552112579350000000000,  0.25000000000000000000000000),
        new Vertex(  0.40172225236892700000000000, -1.23637342453002930000000000,  0.25000000000000000000000000),
        new Vertex(  0.50987821817398070000000000, -1.56924319267272950000000000,  0.25000000000000000000000000),
        new Vertex(  0.40172225236892700000000000, -1.23637342453002930000000000,  0.25000000000000000000000000),
        new Vertex(  1.16672658920288090000000000, -1.16672575473785400000000000,  0.25000000000000000000000000),
        new Vertex(  1.05172193050384520000000000, -0.76412087678909300000000000,  0.25000000000000000000000000),
        new Vertex(  1.33487796783447270000000000, -0.96984571218490600000000000,  0.25000000000000000000000000),
        new Vertex(  1.05172193050384520000000000, -0.76412087678909300000000000,  0.25000000000000000000000000),
        new Vertex(  1.62968575954437260000000000, -0.25811669230461120000000000,  0.25000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000022729921056452440000,  0.25000000000000000000000000),
        new Vertex(  1.64999997615814200000000000,  0.00000028849515842921390000,  0.25000000000000000000000000),
        new End(),
        new Begin(GL2.GL_QUADS),
        new Vertex(  1.64999997615814200000000000,  0.00000000000000000000000000,  0.25000000000000000000000000),
        new Vertex(  2.32106757164001460000000000,  0.36762100458145140000000000,  0.25000000000000000000000000),
        new Vertex(  2.23498272895813000000000000,  0.72618991136550900000000000,  0.25000000000000000000000000),
        new Vertex(  1.47016072273254400000000000,  0.74908435344696040000000000,  0.25000000000000000000000000),
        new Vertex(  1.33487808704376220000000000,  0.96984565258026120000000000,  0.25000000000000000000000000),
        new Vertex(  1.66170084476470950000000000,  1.66170084476470950000000000,  0.25000000000000000000000000),
        new Vertex(  1.38129532337188720000000000,  1.90118992328643800000000000,  0.25000000000000000000000000),
        new Vertex(  0.74908435344696040000000000,  1.47016072273254400000000000,  0.25000000000000000000000000),
        new Vertex(  0.50987797975540160000000000,  1.56924331188201900000000000,  0.25000000000000000000000000),
        new Vertex(  0.36762076616287230000000000,  2.32106757164001460000000000,  0.25000000000000000000000000),
        new Vertex( -0.00000010272175643422088000,  2.34999990463256840000000000,  0.25000000000000000000000000),
        new Vertex( -0.25811684131622314000000000,  1.62968575954437260000000000,  0.25000000000000000000000000),
        new Vertex( -0.50987809896469120000000000,  1.56924319267272950000000000,  0.25000000000000000000000000),
        new Vertex( -1.06687784194946300000000000,  2.09386515617370600000000000,  0.25000000000000000000000000),
        new Vertex( -1.38129508495330800000000000,  1.90118992328643800000000000,  0.25000000000000000000000000),
        new Vertex( -1.16672611236572270000000000,  1.16672611236572270000000000,  0.25000000000000000000000000),
        new Vertex( -1.33487808704376220000000000,  0.96984553337097170000000000,  0.25000000000000000000000000),
        new Vertex( -2.09386539459228500000000000,  1.06687736511230470000000000,  0.25000000000000000000000000),
        new Vertex( -2.23498296737670900000000000,  0.72618943452835080000000000,  0.25000000000000000000000000),
        new Vertex( -1.62968575954437260000000000,  0.25811684131622314000000000,  0.25000000000000000000000000),
        new Vertex( -1.64999997615814200000000000, -0.00000014424757921460696000,  0.25000000000000000000000000),
        new Vertex( -2.32106733322143550000000000, -0.36762133240699770000000000,  0.25000000000000000000000000),
        new Vertex( -2.23498272895813000000000000, -0.72618985176086430000000000,  0.25000000000000000000000000),
        new Vertex( -1.47016072273254400000000000, -0.74908441305160520000000000,  0.25000000000000000000000000),
        new Vertex( -1.33487796783447270000000000, -0.96984583139419560000000000,  0.25000000000000000000000000),
        new Vertex( -1.66170060634613040000000000, -1.66170108318328860000000000,  0.25000000000000000000000000),
        new Vertex( -1.38129484653472900000000000, -1.90119016170501700000000000,  0.25000000000000000000000000),
        new Vertex( -0.74908387660980220000000000, -1.47016096115112300000000000,  0.25000000000000000000000000),
        new Vertex( -0.50987744331359860000000000, -1.56924331188201900000000000,  0.25000000000000000000000000),
        new Vertex( -0.36761999130249023000000000, -2.32106781005859380000000000,  0.25000000000000000000000000),
        new Vertex(  0.00000114859074074047380000, -2.34999990463256840000000000,  0.25000000000000000000000000),
        new Vertex(  0.25811776518821716000000000, -1.62968552112579350000000000,  0.25000000000000000000000000),
        new Vertex(  0.50987821817398070000000000, -1.56924319267272950000000000,  0.25000000000000000000000000),
        new Vertex(  1.06687808036804200000000000, -2.09386491775512700000000000,  0.25000000000000000000000000),
        new Vertex(  1.38129580020904540000000000, -1.90118944644927980000000000,  0.25000000000000000000000000),
        new Vertex(  1.16672658920288090000000000, -1.16672575473785400000000000,  0.25000000000000000000000000),
        new Vertex(  1.33487796783447270000000000, -0.96984571218490600000000000,  0.25000000000000000000000000),
        new Vertex(  2.09386515617370600000000000, -1.06687772274017330000000000,  0.25000000000000000000000000),
        new Vertex(  2.23498272895813000000000000, -0.72618979215621950000000000,  0.25000000000000000000000000),
        new Vertex(  1.62968575954437260000000000, -0.25811669230461120000000000,  0.25000000000000000000000000),
        new End(),
        new Begin(GL2.GL_QUAD_STRIP),
        new Vertex(  1.64999997615814200000000000,  0.00000000000000000000000000, -0.25000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000000000000000000000000, -0.25000000000000000000000000),
        new Vertex(  1.47016072273254400000000000,  0.74908435344696040000000000, -0.25000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000000000000000000000000, -0.25000000000000000000000000),
        new Vertex(  1.33487808704376220000000000,  0.96984565258026120000000000, -0.25000000000000000000000000),
        new Vertex(  1.05172204971313480000000000,  0.76412081718444820000000000, -0.25000000000000000000000000),
        new Vertex(  0.74908435344696040000000000,  1.47016072273254400000000000, -0.25000000000000000000000000),
        new Vertex(  1.05172204971313480000000000,  0.76412081718444820000000000, -0.25000000000000000000000000),
        new Vertex(  0.50987797975540160000000000,  1.56924331188201900000000000, -0.25000000000000000000000000),
        new Vertex(  0.40172204375267030000000000,  1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex( -0.25811684131622314000000000,  1.62968575954437260000000000, -0.25000000000000000000000000),
        new Vertex(  0.40172204375267030000000000,  1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex( -0.50987809896469120000000000,  1.56924319267272950000000000, -0.25000000000000000000000000),
        new Vertex( -0.40172213315963745000000000,  1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex( -1.16672611236572270000000000,  1.16672611236572270000000000, -0.25000000000000000000000000),
        new Vertex( -0.40172213315963745000000000,  1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex( -1.33487808704376220000000000,  0.96984553337097170000000000, -0.25000000000000000000000000),
        new Vertex( -1.05172216892242430000000000,  0.76412069797515870000000000, -0.25000000000000000000000000),
        new Vertex( -1.62968575954437260000000000,  0.25811684131622314000000000, -0.25000000000000000000000000),
        new Vertex( -1.05172216892242430000000000,  0.76412069797515870000000000, -0.25000000000000000000000000),
        new Vertex( -1.64999997615814200000000000, -0.00000014424757921460696000, -0.25000000000000000000000000),
        new Vertex( -1.29999995231628420000000000, -0.00000011364960528226220000, -0.25000000000000000000000000),
        new Vertex( -1.47016072273254400000000000, -0.74908441305160520000000000, -0.25000000000000000000000000),
        new Vertex( -1.29999995231628420000000000, -0.00000011364960528226220000, -0.25000000000000000000000000),
        new Vertex( -1.33487796783447270000000000, -0.96984583139419560000000000, -0.25000000000000000000000000),
        new Vertex( -1.05172193050384520000000000, -0.76412093639373780000000000, -0.25000000000000000000000000),
        new Vertex( -0.74908387660980220000000000, -1.47016096115112300000000000, -0.25000000000000000000000000),
        new Vertex( -1.05172193050384520000000000, -0.76412093639373780000000000, -0.25000000000000000000000000),
        new Vertex( -0.50987744331359860000000000, -1.56924331188201900000000000, -0.25000000000000000000000000),
        new Vertex( -0.40172162652015686000000000, -1.23637354373931880000000000, -0.25000000000000000000000000),
        new Vertex(  0.25811776518821716000000000, -1.62968552112579350000000000, -0.25000000000000000000000000),
        new Vertex( -0.40172162652015686000000000, -1.23637354373931880000000000, -0.25000000000000000000000000),
        new Vertex(  0.50987821817398070000000000, -1.56924319267272950000000000, -0.25000000000000000000000000),
        new Vertex(  0.40172225236892700000000000, -1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex(  1.16672658920288090000000000, -1.16672575473785400000000000, -0.25000000000000000000000000),
        new Vertex(  0.40172225236892700000000000, -1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex(  1.33487796783447270000000000, -0.96984571218490600000000000, -0.25000000000000000000000000),
        new Vertex(  1.05172193050384520000000000, -0.76412087678909300000000000, -0.25000000000000000000000000),
        new Vertex(  1.62968575954437260000000000, -0.25811669230461120000000000, -0.25000000000000000000000000),
        new Vertex(  1.05172193050384520000000000, -0.76412087678909300000000000, -0.25000000000000000000000000),
        new Vertex(  1.64999997615814200000000000,  0.00000028849515842921390000, -0.25000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000022729921056452440000, -0.25000000000000000000000000),
        new Vertex(  1.47016048431396480000000000,  0.74908483028411870000000000, -0.25000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000022729921056452440000, -0.25000000000000000000000000),
        new End(),
        new Begin(GL2.GL_QUADS),
        new Vertex(  1.47016072273254400000000000,  0.74908435344696040000000000, -0.25000000000000000000000000),
        new Vertex(  2.23498272895813000000000000,  0.72618991136550900000000000, -0.25000000000000000000000000),
        new Vertex(  2.32106757164001460000000000,  0.36762100458145140000000000, -0.25000000000000000000000000),
        new Vertex(  1.64999997615814200000000000,  0.00000000000000000000000000, -0.25000000000000000000000000),
        new Vertex(  0.74908435344696040000000000,  1.47016072273254400000000000, -0.25000000000000000000000000),
        new Vertex(  1.38129532337188720000000000,  1.90118992328643800000000000, -0.25000000000000000000000000),
        new Vertex(  1.66170084476470950000000000,  1.66170084476470950000000000, -0.25000000000000000000000000),
        new Vertex(  1.33487808704376220000000000,  0.96984565258026120000000000, -0.25000000000000000000000000),
        new Vertex( -0.25811684131622314000000000,  1.62968575954437260000000000, -0.25000000000000000000000000),
        new Vertex( -0.00000010272175643422088000,  2.34999990463256840000000000, -0.25000000000000000000000000),
        new Vertex(  0.36762076616287230000000000,  2.32106757164001460000000000, -0.25000000000000000000000000),
        new Vertex(  0.50987797975540160000000000,  1.56924331188201900000000000, -0.25000000000000000000000000),
        new Vertex( -1.16672611236572270000000000,  1.16672611236572270000000000, -0.25000000000000000000000000),
        new Vertex( -1.38129508495330800000000000,  1.90118992328643800000000000, -0.25000000000000000000000000),
        new Vertex( -1.06687784194946300000000000,  2.09386515617370600000000000, -0.25000000000000000000000000),
        new Vertex( -0.50987809896469120000000000,  1.56924319267272950000000000, -0.25000000000000000000000000),
        new Vertex( -1.62968575954437260000000000,  0.25811684131622314000000000, -0.25000000000000000000000000),
        new Vertex( -2.23498296737670900000000000,  0.72618943452835080000000000, -0.25000000000000000000000000),
        new Vertex( -2.09386539459228500000000000,  1.06687736511230470000000000, -0.25000000000000000000000000),
        new Vertex( -1.33487808704376220000000000,  0.96984553337097170000000000, -0.25000000000000000000000000),
        new Vertex( -1.47016072273254400000000000, -0.74908441305160520000000000, -0.25000000000000000000000000),
        new Vertex( -2.23498272895813000000000000, -0.72618985176086430000000000, -0.25000000000000000000000000),
        new Vertex( -2.32106733322143550000000000, -0.36762133240699770000000000, -0.25000000000000000000000000),
        new Vertex( -1.64999997615814200000000000, -0.00000014424757921460696000, -0.25000000000000000000000000),
        new Vertex( -0.74908387660980220000000000, -1.47016096115112300000000000, -0.25000000000000000000000000),
        new Vertex( -1.38129484653472900000000000, -1.90119016170501700000000000, -0.25000000000000000000000000),
        new Vertex( -1.66170060634613040000000000, -1.66170108318328860000000000, -0.25000000000000000000000000),
        new Vertex( -1.33487796783447270000000000, -0.96984583139419560000000000, -0.25000000000000000000000000),
        new Vertex(  0.25811776518821716000000000, -1.62968552112579350000000000, -0.25000000000000000000000000),
        new Vertex(  0.00000114859074074047380000, -2.34999990463256840000000000, -0.25000000000000000000000000),
        new Vertex( -0.36761999130249023000000000, -2.32106781005859380000000000, -0.25000000000000000000000000),
        new Vertex( -0.50987744331359860000000000, -1.56924331188201900000000000, -0.25000000000000000000000000),
        new Vertex(  1.16672658920288090000000000, -1.16672575473785400000000000, -0.25000000000000000000000000),
        new Vertex(  1.38129580020904540000000000, -1.90118944644927980000000000, -0.25000000000000000000000000),
        new Vertex(  1.06687808036804200000000000, -2.09386491775512700000000000, -0.25000000000000000000000000),
        new Vertex(  0.50987821817398070000000000, -1.56924319267272950000000000, -0.25000000000000000000000000),
        new Vertex(  1.62968575954437260000000000, -0.25811669230461120000000000, -0.25000000000000000000000000),
        new Vertex(  2.23498272895813000000000000, -0.72618979215621950000000000, -0.25000000000000000000000000),
        new Vertex(  2.09386515617370600000000000, -1.06687772274017330000000000, -0.25000000000000000000000000),
        new Vertex(  1.33487796783447270000000000, -0.96984571218490600000000000, -0.25000000000000000000000000),
        new End(),
        new Begin(GL2.GL_QUAD_STRIP),
        new Vertex(  1.64999997615814200000000000,  0.00000000000000000000000000,  0.25000000000000000000000000),
        new Vertex(  1.64999997615814200000000000,  0.00000000000000000000000000, -0.25000000000000000000000000),
        new Normal(  0.48044690489768980000000000, -0.87702375650405880000000000,  0.00000000000000000000000000),
        new Vertex(  2.32106757164001460000000000,  0.36762100458145140000000000,  0.25000000000000000000000000),
        new Vertex(  2.32106757164001460000000000,  0.36762100458145140000000000, -0.25000000000000000000000000),
        new Normal(  1.00000000000000000000000000,  0.00000000000000000000000000,  0.00000000000000000000000000),
        new Vertex(  2.23498272895813000000000000,  0.72618991136550900000000000,  0.25000000000000000000000000),
        new Vertex(  2.23498272895813000000000000,  0.72618991136550900000000000, -0.25000000000000000000000000),
        new Normal(  0.02289444208145141600000000,  0.76482200622558590000000000,  0.00000000000000000000000000),
        new Vertex(  1.47016072273254400000000000,  0.74908435344696040000000000,  0.25000000000000000000000000),
        new Vertex(  1.47016072273254400000000000,  0.74908435344696040000000000, -0.25000000000000000000000000),
        new Normal(  1.00000000000000000000000000,  0.00000000000000000000000000,  0.00000000000000000000000000),
        new Vertex(  1.33487808704376220000000000,  0.96984565258026120000000000,  0.25000000000000000000000000),
        new Vertex(  1.33487808704376220000000000,  0.96984565258026120000000000, -0.25000000000000000000000000),
        new Normal(  0.90419143438339230000000000, -0.42712745070457460000000000,  0.00000000000000000000000000),
        new Vertex(  1.66170084476470950000000000,  1.66170084476470950000000000,  0.25000000000000000000000000),
        new Vertex(  1.66170084476470950000000000,  1.66170084476470950000000000, -0.25000000000000000000000000),
        new Normal(  0.80901700258255000000000000,  0.58778524398803710000000000,  0.00000000000000000000000000),
        new Vertex(  1.38129532337188720000000000,  1.90118992328643800000000000,  0.25000000000000000000000000),
        new Vertex(  1.38129532337188720000000000,  1.90118992328643800000000000, -0.25000000000000000000000000),
        new Normal( -0.43102920055389404000000000,  0.63221096992492680000000000,  0.00000000000000000000000000),
        new Vertex(  0.74908435344696040000000000,  1.47016072273254400000000000,  0.25000000000000000000000000),
        new Vertex(  0.74908435344696040000000000,  1.47016072273254400000000000, -0.25000000000000000000000000),
        new Normal(  0.80901700258255000000000000,  0.58778524398803710000000000,  0.00000000000000000000000000),
        new Vertex(  0.50987797975540160000000000,  1.56924331188201900000000000,  0.25000000000000000000000000),
        new Vertex(  0.50987797975540160000000000,  1.56924331188201900000000000, -0.25000000000000000000000000),
        new Normal(  0.98256546258926390000000000,  0.18591715395450592000000000,  0.00000000000000000000000000),
        new Vertex(  0.36762076616287230000000000,  2.32106757164001460000000000,  0.25000000000000000000000000),
        new Vertex(  0.36762076616287230000000000,  2.32106757164001460000000000, -0.25000000000000000000000000),
        new Normal(  0.30901697278022766000000000,  0.95105654001235960000000000,  0.00000000000000000000000000),
        new Vertex( -0.00000010272175643422088000,  2.34999990463256840000000000,  0.25000000000000000000000000),
        new Vertex( -0.00000010272175643422088000,  2.34999990463256840000000000, -0.25000000000000000000000000),
        new Normal( -0.72031414508819580000000000,  0.25811675190925600000000000,  0.00000000000000000000000000),
        new Vertex( -0.25811684131622314000000000,  1.62968575954437260000000000,  0.25000000000000000000000000),
        new Vertex( -0.25811684131622314000000000,  1.62968575954437260000000000, -0.25000000000000000000000000),
        new Normal(  0.30901697278022766000000000,  0.95105654001235960000000000,  0.00000000000000000000000000),
        new Vertex( -0.50987809896469120000000000,  1.56924319267272950000000000,  0.25000000000000000000000000),
        new Vertex( -0.50987809896469120000000000,  1.56924319267272950000000000, -0.25000000000000000000000000),
        new Normal(  0.68563282489776610000000000,  0.72794759273529050000000000,  0.00000000000000000000000000),
        new Vertex( -1.06687784194946300000000000,  2.09386515617370600000000000,  0.25000000000000000000000000),
        new Vertex( -1.06687784194946300000000000,  2.09386515617370600000000000, -0.25000000000000000000000000),
        new Normal( -0.30901703238487244000000000,  0.95105648040771480000000000,  0.00000000000000000000000000),
        new Vertex( -1.38129508495330800000000000,  1.90118992328643800000000000,  0.25000000000000000000000000),
        new Vertex( -1.38129508495330800000000000,  1.90118992328643800000000000, -0.25000000000000000000000000),
        new Normal( -0.73446381092071530000000000, -0.21456897258758545000000000,  0.00000000000000000000000000),
        new Vertex( -1.16672611236572270000000000,  1.16672611236572270000000000,  0.25000000000000000000000000),
        new Vertex( -1.16672611236572270000000000,  1.16672611236572270000000000, -0.25000000000000000000000000),
        new Normal( -0.30901703238487244000000000,  0.95105648040771480000000000,  0.00000000000000000000000000),
        new Vertex( -1.33487808704376220000000000,  0.96984553337097170000000000,  0.25000000000000000000000000),
        new Vertex( -1.33487808704376220000000000,  0.96984553337097170000000000, -0.25000000000000000000000000),
        new Normal(  0.12681171298027039000000000,  0.99192684888839720000000000,  0.00000000000000000000000000),
        new Vertex( -2.09386539459228500000000000,  1.06687736511230470000000000,  0.25000000000000000000000000),
        new Vertex( -2.09386539459228500000000000,  1.06687736511230470000000000, -0.25000000000000000000000000),
        new Normal( -0.80901706218719480000000000,  0.58778518438339230000000000,  0.00000000000000000000000000),
        new Vertex( -2.23498296737670900000000000,  0.72618943452835080000000000,  0.25000000000000000000000000),
        new Vertex( -2.23498296737670900000000000,  0.72618943452835080000000000, -0.25000000000000000000000000),
        new Normal( -0.46807259321212770000000000, -0.60529720783233640000000000,  0.00000000000000000000000000),
        new Vertex( -1.62968575954437260000000000,  0.25811684131622314000000000,  0.25000000000000000000000000),
        new Vertex( -1.62968575954437260000000000,  0.25811684131622314000000000, -0.25000000000000000000000000),
        new Normal( -0.80901706218719480000000000,  0.58778518438339230000000000,  0.00000000000000000000000000),
        new Vertex( -1.64999997615814200000000000, -0.00000014424757921460696000,  0.25000000000000000000000000),
        new Vertex( -1.64999997615814200000000000, -0.00000014424757921460696000, -0.25000000000000000000000000),
        new Normal( -0.48044723272323610000000000,  0.87702357769012450000000000,  0.00000000000000000000000000),
        new Vertex( -2.32106733322143550000000000, -0.36762133240699770000000000,  0.25000000000000000000000000),
        new Vertex( -2.32106733322143550000000000, -0.36762133240699770000000000, -0.25000000000000000000000000),
        new Normal( -1.00000000000000000000000000, -0.00000008742277657347586000,  0.00000000000000000000000000),
        new Vertex( -2.23498272895813000000000000, -0.72618985176086430000000000,  0.25000000000000000000000000),
        new Vertex( -2.23498272895813000000000000, -0.72618985176086430000000000, -0.25000000000000000000000000),
        new Normal( -0.02289456129074096700000000, -0.76482200622558590000000000,  0.00000000000000000000000000),
        new Vertex( -1.47016072273254400000000000, -0.74908441305160520000000000,  0.25000000000000000000000000),
        new Vertex( -1.47016072273254400000000000, -0.74908441305160520000000000, -0.25000000000000000000000000),
        new Normal( -1.00000000000000000000000000, -0.00000008742277657347586000,  0.00000000000000000000000000),
        new Vertex( -1.33487796783447270000000000, -0.96984583139419560000000000,  0.25000000000000000000000000),
        new Vertex( -1.33487796783447270000000000, -0.96984583139419560000000000, -0.25000000000000000000000000),
        new Normal( -0.90419155359268190000000000,  0.42712730169296265000000000,  0.00000000000000000000000000),
        new Vertex( -1.66170060634613040000000000, -1.66170108318328860000000000,  0.25000000000000000000000000),
        new Vertex( -1.66170060634613040000000000, -1.66170108318328860000000000, -0.25000000000000000000000000),
        new Normal( -0.80901694297790530000000000, -0.58778536319732670000000000,  0.00000000000000000000000000),
        new Vertex( -1.38129484653472900000000000, -1.90119016170501700000000000,  0.25000000000000000000000000),
        new Vertex( -1.38129484653472900000000000, -1.90119016170501700000000000, -0.25000000000000000000000000),
        new Normal(  0.43102920055389404000000000, -0.63221096992492680000000000,  0.00000000000000000000000000),
        new Vertex( -0.74908387660980220000000000, -1.47016096115112300000000000,  0.25000000000000000000000000),
        new Vertex( -0.74908387660980220000000000, -1.47016096115112300000000000, -0.25000000000000000000000000),
        new Normal( -0.80901694297790530000000000, -0.58778536319732670000000000,  0.00000000000000000000000000),
        new Vertex( -0.50987744331359860000000000, -1.56924331188201900000000000,  0.25000000000000000000000000),
        new Vertex( -0.50987744331359860000000000, -1.56924331188201900000000000, -0.25000000000000000000000000),
        new Normal( -0.98256540298461910000000000, -0.18591739237308502000000000,  0.00000000000000000000000000),
        new Vertex( -0.36761999130249023000000000, -2.32106781005859380000000000,  0.25000000000000000000000000),
        new Vertex( -0.36761999130249023000000000, -2.32106781005859380000000000, -0.25000000000000000000000000),
        new Normal( -0.30901664495468140000000000, -0.95105659961700440000000000,  0.00000000000000000000000000),
        new Vertex(  0.00000114859074074047380000, -2.34999990463256840000000000,  0.25000000000000000000000000),
        new Vertex(  0.00000114859074074047380000, -2.34999990463256840000000000, -0.25000000000000000000000000),
        new Normal(  0.72031438350677490000000000, -0.25811660289764404000000000,  0.00000000000000000000000000),
        new Vertex(  0.25811776518821716000000000, -1.62968552112579350000000000,  0.25000000000000000000000000),
        new Vertex(  0.25811776518821716000000000, -1.62968552112579350000000000, -0.25000000000000000000000000),
        new Normal( -0.30901664495468140000000000, -0.95105659961700440000000000,  0.00000000000000000000000000),
        new Vertex(  0.50987821817398070000000000, -1.56924319267272950000000000,  0.25000000000000000000000000),
        new Vertex(  0.50987821817398070000000000, -1.56924319267272950000000000, -0.25000000000000000000000000),
        new Normal( -0.68563252687454220000000000, -0.72794783115386960000000000,  0.00000000000000000000000000),
        new Vertex(  1.06687808036804200000000000, -2.09386491775512700000000000,  0.25000000000000000000000000),
        new Vertex(  1.06687808036804200000000000, -2.09386491775512700000000000, -0.25000000000000000000000000),
        new Normal(  0.30901712179183960000000000, -0.95105648040771480000000000,  0.00000000000000000000000000),
        new Vertex(  1.38129580020904540000000000, -1.90118944644927980000000000,  0.25000000000000000000000000),
        new Vertex(  1.38129580020904540000000000, -1.90118944644927980000000000, -0.25000000000000000000000000),
        new Normal(  0.73446369171142580000000000,  0.21456921100616455000000000,  0.00000000000000000000000000),
        new Vertex(  1.16672658920288090000000000, -1.16672575473785400000000000,  0.25000000000000000000000000),
        new Vertex(  1.16672658920288090000000000, -1.16672575473785400000000000, -0.25000000000000000000000000),
        new Normal(  0.30901712179183960000000000, -0.95105648040771480000000000,  0.00000000000000000000000000),
        new Vertex(  1.33487796783447270000000000, -0.96984571218490600000000000,  0.25000000000000000000000000),
        new Vertex(  1.33487796783447270000000000, -0.96984571218490600000000000, -0.25000000000000000000000000),
        new Normal( -0.12681195139884950000000000, -0.99192672967910770000000000,  0.00000000000000000000000000),
        new Vertex(  2.09386515617370600000000000, -1.06687772274017330000000000,  0.25000000000000000000000000),
        new Vertex(  2.09386515617370600000000000, -1.06687772274017330000000000, -0.25000000000000000000000000),
        new Normal(  0.80901694297790530000000000, -0.58778530359268190000000000,  0.00000000000000000000000000),
        new Vertex(  2.23498272895813000000000000, -0.72618979215621950000000000,  0.25000000000000000000000000),
        new Vertex(  2.23498272895813000000000000, -0.72618979215621950000000000, -0.25000000000000000000000000),
        new Normal(  0.46807309985160830000000000,  0.60529696941375730000000000,  0.00000000000000000000000000),
        new Vertex(  1.62968575954437260000000000, -0.25811669230461120000000000,  0.25000000000000000000000000),
        new Vertex(  1.62968575954437260000000000, -0.25811669230461120000000000, -0.25000000000000000000000000),
        new Normal(  0.80901694297790530000000000, -0.58778530359268190000000000,  0.00000000000000000000000000),
        new Vertex(  1.64999997615814200000000000,  0.00000000000000000000000000,  0.25000000000000000000000000),
        new Vertex(  1.64999997615814200000000000,  0.00000000000000000000000000, -0.25000000000000000000000000),
        new End(),
        new ShadeModel(GL2.GL_SMOOTH),
        new Begin(GL2.GL_QUAD_STRIP),
        new Normal( -1.00000000000000000000000000, -0.00000000000000000000000000,  0.00000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000000000000000000000000, -0.25000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000000000000000000000000,  0.25000000000000000000000000),
        new Normal( -0.80901700258255000000000000, -0.58778524398803710000000000,  0.00000000000000000000000000),
        new Vertex(  1.05172204971313480000000000,  0.76412081718444820000000000, -0.25000000000000000000000000),
        new Vertex(  1.05172204971313480000000000,  0.76412081718444820000000000,  0.25000000000000000000000000),
        new Normal( -0.30901697278022766000000000, -0.95105654001235960000000000,  0.00000000000000000000000000),
        new Vertex(  0.40172204375267030000000000,  1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex(  0.40172204375267030000000000,  1.23637342453002930000000000,  0.25000000000000000000000000),
        new Normal(  0.30901703238487244000000000, -0.95105648040771480000000000,  0.00000000000000000000000000),
        new Vertex( -0.40172213315963745000000000,  1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex( -0.40172213315963745000000000,  1.23637342453002930000000000,  0.25000000000000000000000000),
        new Normal(  0.80901706218719480000000000, -0.58778518438339230000000000,  0.00000000000000000000000000),
        new Vertex( -1.05172216892242430000000000,  0.76412069797515870000000000, -0.25000000000000000000000000),
        new Vertex( -1.05172216892242430000000000,  0.76412069797515870000000000,  0.25000000000000000000000000),
        new Normal(  1.00000000000000000000000000,  0.00000008742277657347586000,  0.00000000000000000000000000),
        new Vertex( -1.29999995231628420000000000, -0.00000011364960528226220000, -0.25000000000000000000000000),
        new Vertex( -1.29999995231628420000000000, -0.00000011364960528226220000,  0.25000000000000000000000000),
        new Normal(  0.80901694297790530000000000,  0.58778536319732670000000000,  0.00000000000000000000000000),
        new Vertex( -1.05172193050384520000000000, -0.76412093639373780000000000, -0.25000000000000000000000000),
        new Vertex( -1.05172193050384520000000000, -0.76412093639373780000000000,  0.25000000000000000000000000),
        new Normal(  0.30901664495468140000000000,  0.95105659961700440000000000,  0.00000000000000000000000000),
        new Vertex( -0.40172162652015686000000000, -1.23637354373931880000000000, -0.25000000000000000000000000),
        new Vertex( -0.40172162652015686000000000, -1.23637354373931880000000000,  0.25000000000000000000000000),
        new Normal( -0.30901712179183960000000000,  0.95105648040771480000000000,  0.00000000000000000000000000),
        new Vertex(  0.40172225236892700000000000, -1.23637342453002930000000000, -0.25000000000000000000000000),
        new Vertex(  0.40172225236892700000000000, -1.23637342453002930000000000,  0.25000000000000000000000000),
        new Normal( -0.80901694297790530000000000,  0.58778530359268190000000000,  0.00000000000000000000000000),
        new Vertex(  1.05172193050384520000000000, -0.76412087678909300000000000, -0.25000000000000000000000000),
        new Vertex(  1.05172193050384520000000000, -0.76412087678909300000000000,  0.25000000000000000000000000),
        new Normal( -1.00000000000000000000000000, -0.00000017484555314695172000,  0.00000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000022729921056452440000, -0.25000000000000000000000000),
        new Vertex(  1.29999995231628420000000000,  0.00000022729921056452440000,  0.25000000000000000000000000),
        new End()
    };



    Gear3(){
        super(MODEL3);

        this.translate(-3.1,  4.2, 0.0);
    }


    public void display(GL2 gl){

        gl.glRotatef(-2.0f * Gears.Angle - 25.0f, 0.0f, 0.0f, 1.0f);
        super.display(gl);
    }
}
