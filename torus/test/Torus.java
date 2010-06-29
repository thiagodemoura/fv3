
package test;

import fv3.Bounds;
import fv3.Camera;
import fv3.csg.Solid;
import fv3.math.Color;
import fv3.math.VertexArray;
import fv3.model.CircumCube;
import fv3.model.Material ;
import fv3.model.Model;
import fv3.model.ShadeModel ;
import fv3.nui.Light;
import fv3.tk.Animator;

import lxl.List;

import javax.media.opengl.GL2;

public class Torus
    extends fv3.World
{

    public static void main(String[] argv){
        try {
            Torus torus = new Torus();
            if (null != argv && 0 != argv.length){
                String arg;
                for (int argc = argv.length, cc = 0; cc < argc; cc++){
                    arg = argv[cc];
                    if ("-dim".equals(arg)){
                        System.out.println(torus.getClass().getName());
                        System.out.println(((Bounds.CircumSphere)torus.getFv3Bounds()).toString("\t"));
                        List<fv3.Component> children = torus.getChildren();
                        for (fv3.Component child: children){
                            if (child instanceof Model){
                                System.out.println(child.getClass().getName());
                                System.out.println(((Model)child).toString("\t"));
                            }
                        }
                    }
                }
                System.exit(0);
            }
            else {
                Animator animator = new Animator(torus);
                animator.start();
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
            System.exit(1);
        }
    }
    private final static VertexArray A = new VertexArray(VertexArray.Type.QuadStrip,52)
        .setVertex(0,1.03827,0.00000,0.0923880)
        .setVertex(1,1.09239,0.00000,0.0382683)
        .setVertex(2,1.00565,0.258207,0.0923880)
        .setVertex(3,1.05807,0.271666,0.0382683)
        .setVertex(4,0.909841,0.500190,0.0923880)
        .setVertex(5,0.957267,0.526262,0.0382683)
        .setVertex(6,0.756865,0.710744,0.0923880)
        .setVertex(7,0.796317,0.747791,0.0382683)
        .setVertex(8,0.556332,0.876639,0.0923880)
        .setVertex(9,0.585331,0.922334,0.0382683)
        .setVertex(10,0.320843,0.987452,0.0923880)
        .setVertex(11,0.337566,1.03892,0.0382683)
        .setVertex(12,0.0651934,1.03622,0.0923880)
        .setVertex(13,0.0685916,1.09023,0.0382683)
        .setVertex(14,-0.194552,1.01988,0.0923880)
        .setVertex(15,-0.204693,1.07304,0.0382683)
        .setVertex(16,-0.442073,0.939453,0.0923880)
        .setVertex(17,-0.465116,0.988422,0.0382683)
        .setVertex(18,-0.661817,0.800000,0.0923880)
        .setVertex(19,-0.696314,0.841699,0.0382683)
        .setVertex(20,-0.839977,0.610279,0.0923880)
        .setVertex(21,-0.883760,0.642090,0.0382683)
        .setVertex(22,-0.965357,0.382212,0.0923880)
        .setVertex(23,-1.01568,0.402135,0.0382683)
        .setVertex(24,-1.03008,0.130130,0.0923880)
        .setVertex(25,-1.08377,0.136913,0.0382683)
        .setVertex(26,-1.03008,-0.130130,0.0923880)
        .setVertex(27,-1.08377,-0.136913,0.0382683)
        .setVertex(28,-0.965357,-0.382212,0.0923880)
        .setVertex(29,-1.01568,-0.402135,0.0382683)
        .setVertex(30,-0.839977,-0.610279,0.0923880)
        .setVertex(31,-0.883760,-0.642090,0.0382683)
        .setVertex(32,-0.661817,-0.800000,0.0923880)
        .setVertex(33,-0.696314,-0.841699,0.0382683)
        .setVertex(34,-0.442073,-0.939453,0.0923880)
        .setVertex(35,-0.465116,-0.988422,0.0382683)
        .setVertex(36,-0.194552,-1.01988,0.0923880)
        .setVertex(37,-0.204693,-1.07304,0.0382683)
        .setVertex(38,0.0651934,-1.03622,0.0923880)
        .setVertex(39,0.0685916,-1.09023,0.0382683)
        .setVertex(40,0.320843,-0.987452,0.0923880)
        .setVertex(41,0.337566,-1.03892,0.0382683)
        .setVertex(42,0.556332,-0.876639,0.0923880)
        .setVertex(43,0.585331,-0.922334,0.0382683)
        .setVertex(44,0.756865,-0.710744,0.0923880)
        .setVertex(45,0.796317,-0.747791,0.0382683)
        .setVertex(46,0.909841,-0.500190,0.0923880)
        .setVertex(47,0.957267,-0.526262,0.0382683)
        .setVertex(48,1.00565,-0.258207,0.0923880)
        .setVertex(49,1.05807,-0.271666,0.0382683)
        .setVertex(50,1.03827,0.00000,0.0923880)
        .setVertex(51,1.09239,0.00000,0.0382683);

    private final static VertexArray B = new VertexArray(VertexArray.Type.QuadStrip,52)
        .setVertex(0,0.961732,0.00000,0.0923880)
        .setVertex(1,1.03827,0.00000,0.0923880)
        .setVertex(2,0.931517,0.239173,0.0923880)
        .setVertex(3,1.00565,0.258207,0.0923880)
        .setVertex(4,0.842772,0.463318,0.0923880)
        .setVertex(5,0.909841,0.500190,0.0923880)
        .setVertex(6,0.701072,0.658351,0.0923880)
        .setVertex(7,0.756865,0.710744,0.0923880)
        .setVertex(8,0.515322,0.812017,0.0923880)
        .setVertex(9,0.556332,0.876639,0.0923880)
        .setVertex(10,0.297191,0.914661,0.0923880)
        .setVertex(11,0.320843,0.987452,0.0923880)
        .setVertex(12,0.0603876,0.959834,0.0923880)
        .setVertex(13,0.0651934,1.03622,0.0923880)
        .setVertex(14,-0.180211,0.944697,0.0923880)
        .setVertex(15,-0.194552,1.01988,0.0923880)
        .setVertex(16,-0.409485,0.870201,0.0923880)
        .setVertex(17,-0.442073,0.939453,0.0923880)
        .setVertex(18,-0.613031,0.741027,0.0923880)
        .setVertex(19,-0.661817,0.800000,0.0923880)
        .setVertex(20,-0.778057,0.565292,0.0923880)
        .setVertex(21,-0.839977,0.610279,0.0923880)
        .setVertex(22,-0.894195,0.354037,0.0923880)
        .setVertex(23,-0.965357,0.382212,0.0923880)
        .setVertex(24,-0.954148,0.120537,0.0923880)
        .setVertex(25,-1.03008,0.130130,0.0923880)
        .setVertex(26,-0.954148,-0.120537,0.0923880)
        .setVertex(27,-1.03008,-0.130130,0.0923880)
        .setVertex(28,-0.894195,-0.354037,0.0923880)
        .setVertex(29,-0.965357,-0.382212,0.0923880)
        .setVertex(30,-0.778057,-0.565292,0.0923880)
        .setVertex(31,-0.839977,-0.610279,0.0923880)
        .setVertex(32,-0.613031,-0.741027,0.0923880)
        .setVertex(33,-0.661817,-0.800000,0.0923880)
        .setVertex(34,-0.409485,-0.870201,0.0923880)
        .setVertex(35,-0.442073,-0.939453,0.0923880)
        .setVertex(36,-0.180211,-0.944697,0.0923880)
        .setVertex(37,-0.194552,-1.01988,0.0923880)
        .setVertex(38,0.0603876,-0.959834,0.0923880)
        .setVertex(39,0.0651934,-1.03622,0.0923880)
        .setVertex(40,0.297191,-0.914661,0.0923880)
        .setVertex(41,0.320843,-0.987452,0.0923880)
        .setVertex(42,0.515322,-0.812017,0.0923880)
        .setVertex(43,0.556332,-0.876639,0.0923880)
        .setVertex(44,0.701072,-0.658351,0.0923880)
        .setVertex(45,0.756865,-0.710744,0.0923880)
        .setVertex(46,0.842772,-0.463318,0.0923880)
        .setVertex(47,0.909841,-0.500190,0.0923880)
        .setVertex(48,0.931517,-0.239173,0.0923880)
        .setVertex(49,1.00565,-0.258207,0.0923880)
        .setVertex(50,0.961732,0.00000,0.0923880)
        .setVertex(51,1.03827,0.00000,0.0923880);

    private final static VertexArray C = new VertexArray(VertexArray.Type.QuadStrip,52)
        .setVertex(0,0.907612,0.00000,0.0382683)
        .setVertex(1,0.961732,0.00000,0.0923880)
        .setVertex(2,0.879098,0.225714,0.0382683)
        .setVertex(3,0.931517,0.239173,0.0923880)
        .setVertex(4,0.795346,0.437245,0.0382683)
        .setVertex(5,0.842772,0.463318,0.0923880)
        .setVertex(6,0.661621,0.621303,0.0382683)
        .setVertex(7,0.701072,0.658351,0.0923880)
        .setVertex(8,0.486323,0.766322,0.0382683)
        .setVertex(9,0.515322,0.812017,0.0923880)
        .setVertex(10,0.280468,0.863190,0.0382683)
        .setVertex(11,0.297191,0.914661,0.0923880)
        .setVertex(12,0.0569894,0.905821,0.0382683)
        .setVertex(13,0.0603876,0.959834,0.0923880)
        .setVertex(14,-0.170070,0.891536,0.0382683)
        .setVertex(15,-0.180211,0.944697,0.0923880)
        .setVertex(16,-0.386442,0.821232,0.0382683)
        .setVertex(17,-0.409485,0.870201,0.0923880)
        .setVertex(18,-0.578534,0.699327,0.0382683)
        .setVertex(19,-0.613031,0.741027,0.0923880)
        .setVertex(20,-0.734274,0.533481,0.0382683)
        .setVertex(21,-0.778057,0.565292,0.0923880)
        .setVertex(22,-0.843876,0.334114,0.0382683)
        .setVertex(23,-0.894195,0.354037,0.0923880)
        .setVertex(24,-0.900455,0.113754,0.0382683)
        .setVertex(25,-0.954148,0.120537,0.0923880)
        .setVertex(26,-0.900455,-0.113754,0.0382683)
        .setVertex(27,-0.954148,-0.120537,0.0923880)
        .setVertex(28,-0.843876,-0.334114,0.0382683)
        .setVertex(29,-0.894195,-0.354037,0.0923880)
        .setVertex(30,-0.734274,-0.533481,0.0382683)
        .setVertex(31,-0.778057,-0.565292,0.0923880)
        .setVertex(32,-0.578534,-0.699327,0.0382683)
        .setVertex(33,-0.613031,-0.741027,0.0923880)
        .setVertex(34,-0.386442,-0.821232,0.0382683)
        .setVertex(35,-0.409485,-0.870201,0.0923880)
        .setVertex(36,-0.170070,-0.891536,0.0382683)
        .setVertex(37,-0.180211,-0.944697,0.0923880)
        .setVertex(38,0.0569894,-0.905821,0.0382683)
        .setVertex(39,0.0603876,-0.959834,0.0923880)
        .setVertex(40,0.280468,-0.863190,0.0382683)
        .setVertex(41,0.297191,-0.914661,0.0923880)
        .setVertex(42,0.486323,-0.766322,0.0382683)
        .setVertex(43,0.515322,-0.812017,0.0923880)
        .setVertex(44,0.661621,-0.621303,0.0382683)
        .setVertex(45,0.701072,-0.658351,0.0923880)
        .setVertex(46,0.795346,-0.437245,0.0382683)
        .setVertex(47,0.842772,-0.463318,0.0923880)
        .setVertex(48,0.879098,-0.225714,0.0382683)
        .setVertex(49,0.931517,-0.239173,0.0923880)
        .setVertex(50,0.907612,0.00000,0.0382683)
        .setVertex(51,0.961732,0.00000,0.0923880);

    private final static VertexArray D = new VertexArray(VertexArray.Type.QuadStrip,52)
        .setVertex(0,0.907612,0.00000,-0.0382683)
        .setVertex(1,0.907612,0.00000,0.0382683)
        .setVertex(2,0.879098,0.225714,-0.0382683)
        .setVertex(3,0.879098,0.225714,0.0382683)
        .setVertex(4,0.795346,0.437245,-0.0382683)
        .setVertex(5,0.795346,0.437245,0.0382683)
        .setVertex(6,0.661621,0.621303,-0.0382683)
        .setVertex(7,0.661621,0.621303,0.0382683)
        .setVertex(8,0.486323,0.766322,-0.0382683)
        .setVertex(9,0.486323,0.766322,0.0382683)
        .setVertex(10,0.280468,0.863190,-0.0382683)
        .setVertex(11,0.280468,0.863190,0.0382683)
        .setVertex(12,0.0569894,0.905821,-0.0382683)
        .setVertex(13,0.0569894,0.905821,0.0382683)
        .setVertex(14,-0.170070,0.891536,-0.0382683)
        .setVertex(15,-0.170070,0.891536,0.0382683)
        .setVertex(16,-0.386442,0.821232,-0.0382683)
        .setVertex(17,-0.386442,0.821232,0.0382683)
        .setVertex(18,-0.578534,0.699327,-0.0382683)
        .setVertex(19,-0.578534,0.699327,0.0382683)
        .setVertex(20,-0.734274,0.533481,-0.0382683)
        .setVertex(21,-0.734274,0.533481,0.0382683)
        .setVertex(22,-0.843876,0.334114,-0.0382683)
        .setVertex(23,-0.843876,0.334114,0.0382683)
        .setVertex(24,-0.900455,0.113754,-0.0382683)
        .setVertex(25,-0.900455,0.113754,0.0382683)
        .setVertex(26,-0.900455,-0.113754,-0.0382683)
        .setVertex(27,-0.900455,-0.113754,0.0382683)
        .setVertex(28,-0.843876,-0.334114,-0.0382683)
        .setVertex(29,-0.843876,-0.334114,0.0382683)
        .setVertex(30,-0.734274,-0.533481,-0.0382683)
        .setVertex(31,-0.734274,-0.533481,0.0382683)
        .setVertex(32,-0.578534,-0.699327,-0.0382683)
        .setVertex(33,-0.578534,-0.699327,0.0382683)
        .setVertex(34,-0.386442,-0.821232,-0.0382683)
        .setVertex(35,-0.386442,-0.821232,0.0382683)
        .setVertex(36,-0.170070,-0.891536,-0.0382683)
        .setVertex(37,-0.170070,-0.891536,0.0382683)
        .setVertex(38,0.0569894,-0.905821,-0.0382683)
        .setVertex(39,0.0569894,-0.905821,0.0382683)
        .setVertex(40,0.280468,-0.863190,-0.0382683)
        .setVertex(41,0.280468,-0.863190,0.0382683)
        .setVertex(42,0.486323,-0.766322,-0.0382683)
        .setVertex(43,0.486323,-0.766322,0.0382683)
        .setVertex(44,0.661621,-0.621303,-0.0382683)
        .setVertex(45,0.661621,-0.621303,0.0382683)
        .setVertex(46,0.795346,-0.437245,-0.0382683)
        .setVertex(47,0.795346,-0.437245,0.0382683)
        .setVertex(48,0.879098,-0.225714,-0.0382683)
        .setVertex(49,0.879098,-0.225714,0.0382683)
        .setVertex(50,0.907612,0.00000,-0.0382683)
        .setVertex(51,0.907612,0.00000,0.0382683);

    private final static VertexArray E = new VertexArray(VertexArray.Type.QuadStrip,52)
        .setVertex(0,0.961732,0.00000,-0.0923880)
        .setVertex(1,0.907612,0.00000,-0.0382683)
        .setVertex(2,0.931517,0.239173,-0.0923880)
        .setVertex(3,0.879098,0.225714,-0.0382683)
        .setVertex(4,0.842772,0.463318,-0.0923880)
        .setVertex(5,0.795346,0.437245,-0.0382683)
        .setVertex(6,0.701072,0.658351,-0.0923880)
        .setVertex(7,0.661621,0.621303,-0.0382683)
        .setVertex(8,0.515322,0.812017,-0.0923880)
        .setVertex(9,0.486323,0.766322,-0.0382683)
        .setVertex(10,0.297191,0.914661,-0.0923880)
        .setVertex(11,0.280468,0.863190,-0.0382683)
        .setVertex(12,0.0603876,0.959834,-0.0923880)
        .setVertex(13,0.0569894,0.905821,-0.0382683)
        .setVertex(14,-0.180211,0.944697,-0.0923880)
        .setVertex(15,-0.170070,0.891536,-0.0382683)
        .setVertex(16,-0.409485,0.870201,-0.0923880)
        .setVertex(17,-0.386442,0.821232,-0.0382683)
        .setVertex(18,-0.613031,0.741027,-0.0923880)
        .setVertex(19,-0.578534,0.699327,-0.0382683)
        .setVertex(20,-0.778057,0.565292,-0.0923880)
        .setVertex(21,-0.734274,0.533481,-0.0382683)
        .setVertex(22,-0.894195,0.354037,-0.0923880)
        .setVertex(23,-0.843876,0.334114,-0.0382683)
        .setVertex(24,-0.954148,0.120537,-0.0923880)
        .setVertex(25,-0.900455,0.113754,-0.0382683)
        .setVertex(26,-0.954148,-0.120537,-0.0923880)
        .setVertex(27,-0.900455,-0.113754,-0.0382683)
        .setVertex(28,-0.894195,-0.354037,-0.0923880)
        .setVertex(29,-0.843876,-0.334114,-0.0382683)
        .setVertex(30,-0.778057,-0.565292,-0.0923880)
        .setVertex(31,-0.734274,-0.533481,-0.0382683)
        .setVertex(32,-0.613031,-0.741027,-0.0923880)
        .setVertex(33,-0.578534,-0.699327,-0.0382683)
        .setVertex(34,-0.409485,-0.870201,-0.0923880)
        .setVertex(35,-0.386442,-0.821232,-0.0382683)
        .setVertex(36,-0.180211,-0.944697,-0.0923880)
        .setVertex(37,-0.170070,-0.891536,-0.0382683)
        .setVertex(38,0.0603876,-0.959834,-0.0923880)
        .setVertex(39,0.0569894,-0.905821,-0.0382683)
        .setVertex(40,0.297191,-0.914661,-0.0923880)
        .setVertex(41,0.280468,-0.863190,-0.0382683)
        .setVertex(42,0.515322,-0.812017,-0.0923880)
        .setVertex(43,0.486323,-0.766322,-0.0382683)
        .setVertex(44,0.701072,-0.658351,-0.0923880)
        .setVertex(45,0.661621,-0.621303,-0.0382683)
        .setVertex(46,0.842772,-0.463318,-0.0923880)
        .setVertex(47,0.795346,-0.437245,-0.0382683)
        .setVertex(48,0.931517,-0.239173,-0.0923880)
        .setVertex(49,0.879098,-0.225714,-0.0382683)
        .setVertex(50,0.961732,0.00000,-0.0923880)
        .setVertex(51,0.907612,0.00000,-0.0382683);

    private final static VertexArray F = new VertexArray(VertexArray.Type.QuadStrip,52)
        .setVertex(0,1.03827,0.00000,-0.0923880)
        .setVertex(1,0.961732,0.00000,-0.0923880)
        .setVertex(2,1.00565,0.258207,-0.0923880)
        .setVertex(3,0.931517,0.239173,-0.0923880)
        .setVertex(4,0.909841,0.500190,-0.0923880)
        .setVertex(5,0.842772,0.463318,-0.0923880)
        .setVertex(6,0.756865,0.710744,-0.0923880)
        .setVertex(7,0.701072,0.658351,-0.0923880)
        .setVertex(8,0.556332,0.876639,-0.0923880)
        .setVertex(9,0.515322,0.812017,-0.0923880)
        .setVertex(10,0.320843,0.987452,-0.0923880)
        .setVertex(11,0.297191,0.914661,-0.0923880)
        .setVertex(12,0.0651934,1.03622,-0.0923880)
        .setVertex(13,0.0603876,0.959834,-0.0923880)
        .setVertex(14,-0.194552,1.01988,-0.0923880)
        .setVertex(15,-0.180211,0.944697,-0.0923880)
        .setVertex(16,-0.442073,0.939453,-0.0923880)
        .setVertex(17,-0.409485,0.870201,-0.0923880)
        .setVertex(18,-0.661817,0.800000,-0.0923880)
        .setVertex(19,-0.613031,0.741027,-0.0923880)
        .setVertex(20,-0.839977,0.610279,-0.0923880)
        .setVertex(21,-0.778057,0.565292,-0.0923880)
        .setVertex(22,-0.965357,0.382212,-0.0923880)
        .setVertex(23,-0.894195,0.354037,-0.0923880)
        .setVertex(24,-1.03008,0.130130,-0.0923880)
        .setVertex(25,-0.954148,0.120537,-0.0923880)
        .setVertex(26,-1.03008,-0.130130,-0.0923880)
        .setVertex(27,-0.954148,-0.120537,-0.0923880)
        .setVertex(28,-0.965357,-0.382212,-0.0923880)
        .setVertex(29,-0.894195,-0.354037,-0.0923880)
        .setVertex(30,-0.839977,-0.610279,-0.0923880)
        .setVertex(31,-0.778057,-0.565292,-0.0923880)
        .setVertex(32,-0.661817,-0.800000,-0.0923880)
        .setVertex(33,-0.613031,-0.741027,-0.0923880)
        .setVertex(34,-0.442073,-0.939453,-0.0923880)
        .setVertex(35,-0.409485,-0.870201,-0.0923880)
        .setVertex(36,-0.194552,-1.01988,-0.0923880)
        .setVertex(37,-0.180211,-0.944697,-0.0923880)
        .setVertex(38,0.0651934,-1.03622,-0.0923880)
        .setVertex(39,0.0603876,-0.959834,-0.0923880)
        .setVertex(40,0.320843,-0.987452,-0.0923880)
        .setVertex(41,0.297191,-0.914661,-0.0923880)
        .setVertex(42,0.556332,-0.876639,-0.0923880)
        .setVertex(43,0.515322,-0.812017,-0.0923880)
        .setVertex(44,0.756865,-0.710744,-0.0923880)
        .setVertex(45,0.701072,-0.658351,-0.0923880)
        .setVertex(46,0.909841,-0.500190,-0.0923880)
        .setVertex(47,0.842772,-0.463318,-0.0923880)
        .setVertex(48,1.00565,-0.258207,-0.0923880)
        .setVertex(49,0.931517,-0.239173,-0.0923880)
        .setVertex(50,1.03827,0.00000,-0.0923880)
        .setVertex(51,0.961732,0.00000,-0.0923880);

    private final static VertexArray G = new VertexArray(VertexArray.Type.QuadStrip,52)
        .setVertex(0,1.09239,0.00000,-0.0382683)
        .setVertex(1,1.03827,0.00000,-0.0923880)
        .setVertex(2,1.05807,0.271666,-0.0382683)
        .setVertex(3,1.00565,0.258207,-0.0923880)
        .setVertex(4,0.957267,0.526262,-0.0382683)
        .setVertex(5,0.909841,0.500190,-0.0923880)
        .setVertex(6,0.796317,0.747791,-0.0382683)
        .setVertex(7,0.756865,0.710744,-0.0923880)
        .setVertex(8,0.585331,0.922334,-0.0382683)
        .setVertex(9,0.556332,0.876639,-0.0923880)
        .setVertex(10,0.337566,1.03892,-0.0382683)
        .setVertex(11,0.320843,0.987452,-0.0923880)
        .setVertex(12,0.0685916,1.09023,-0.0382683)
        .setVertex(13,0.0651934,1.03622,-0.0923880)
        .setVertex(14,-0.204693,1.07304,-0.0382683)
        .setVertex(15,-0.194552,1.01988,-0.0923880)
        .setVertex(16,-0.465116,0.988422,-0.0382683)
        .setVertex(17,-0.442073,0.939453,-0.0923880)
        .setVertex(18,-0.696314,0.841699,-0.0382683)
        .setVertex(19,-0.661817,0.800000,-0.0923880)
        .setVertex(20,-0.883760,0.642090,-0.0382683)
        .setVertex(21,-0.839977,0.610279,-0.0923880)
        .setVertex(22,-1.01568,0.402135,-0.0382683)
        .setVertex(23,-0.965357,0.382212,-0.0923880)
        .setVertex(24,-1.08377,0.136913,-0.0382683)
        .setVertex(25,-1.03008,0.130130,-0.0923880)
        .setVertex(26,-1.08377,-0.136913,-0.0382683)
        .setVertex(27,-1.03008,-0.130130,-0.0923880)
        .setVertex(28,-1.01568,-0.402135,-0.0382683)
        .setVertex(29,-0.965357,-0.382212,-0.0923880)
        .setVertex(30,-0.883760,-0.642090,-0.0382683)
        .setVertex(31,-0.839977,-0.610279,-0.0923880)
        .setVertex(32,-0.696314,-0.841699,-0.0382683)
        .setVertex(33,-0.661817,-0.800000,-0.0923880)
        .setVertex(34,-0.465116,-0.988422,-0.0382683)
        .setVertex(35,-0.442073,-0.939453,-0.0923880)
        .setVertex(36,-0.204693,-1.07304,-0.0382683)
        .setVertex(37,-0.194552,-1.01988,-0.0923880)
        .setVertex(38,0.0685916,-1.09023,-0.0382683)
        .setVertex(39,0.0651934,-1.03622,-0.0923880)
        .setVertex(40,0.337566,-1.03892,-0.0382683)
        .setVertex(41,0.320843,-0.987452,-0.0923880)
        .setVertex(42,0.585331,-0.922334,-0.0382683)
        .setVertex(43,0.556332,-0.876639,-0.0923880)
        .setVertex(44,0.796317,-0.747791,-0.0382683)
        .setVertex(45,0.756865,-0.710744,-0.0923880)
        .setVertex(46,0.957267,-0.526262,-0.0382683)
        .setVertex(47,0.909841,-0.500190,-0.0923880)
        .setVertex(48,1.05807,-0.271666,-0.0382683)
        .setVertex(49,1.00565,-0.258207,-0.0923880)
        .setVertex(50,1.09239,0.00000,-0.0382683)
        .setVertex(51,1.03827,0.00000,-0.0923880);

    private final static VertexArray H = new VertexArray(VertexArray.Type.QuadStrip,52)
        .setVertex(0,1.09239,0.00000,0.0382683)
        .setVertex(1,1.09239,0.00000,-0.0382683)
        .setVertex(2,1.05807,0.271666,0.0382683)
        .setVertex(3,1.05807,0.271666,-0.0382683)
        .setVertex(4,0.957267,0.526262,0.0382683)
        .setVertex(5,0.957267,0.526262,-0.0382683)
        .setVertex(6,0.796317,0.747791,0.0382683)
        .setVertex(7,0.796317,0.747791,-0.0382683)
        .setVertex(8,0.585331,0.922334,0.0382683)
        .setVertex(9,0.585331,0.922334,-0.0382683)
        .setVertex(10,0.337566,1.03892,0.0382683)
        .setVertex(11,0.337566,1.03892,-0.0382683)
        .setVertex(12,0.0685916,1.09023,0.0382683)
        .setVertex(13,0.0685916,1.09023,-0.0382683)
        .setVertex(14,-0.204693,1.07304,0.0382683)
        .setVertex(15,-0.204693,1.07304,-0.0382683)
        .setVertex(16,-0.465116,0.988422,0.0382683)
        .setVertex(17,-0.465116,0.988422,-0.0382683)
        .setVertex(18,-0.696314,0.841699,0.0382683)
        .setVertex(19,-0.696314,0.841699,-0.0382683)
        .setVertex(20,-0.883760,0.642090,0.0382683)
        .setVertex(21,-0.883760,0.642090,-0.0382683)
        .setVertex(22,-1.01568,0.402135,0.0382683)
        .setVertex(23,-1.01568,0.402135,-0.0382683)
        .setVertex(24,-1.08377,0.136913,0.0382683)
        .setVertex(25,-1.08377,0.136913,-0.0382683)
        .setVertex(26,-1.08377,-0.136913,0.0382683)
        .setVertex(27,-1.08377,-0.136913,-0.0382683)
        .setVertex(28,-1.01568,-0.402135,0.0382683)
        .setVertex(29,-1.01568,-0.402135,-0.0382683)
        .setVertex(30,-0.883760,-0.642090,0.0382683)
        .setVertex(31,-0.883760,-0.642090,-0.0382683)
        .setVertex(32,-0.696314,-0.841699,0.0382683)
        .setVertex(33,-0.696314,-0.841699,-0.0382683)
        .setVertex(34,-0.465116,-0.988422,0.0382683)
        .setVertex(35,-0.465116,-0.988422,-0.0382683)
        .setVertex(36,-0.204693,-1.07304,0.0382683)
        .setVertex(37,-0.204693,-1.07304,-0.0382683)
        .setVertex(38,0.0685916,-1.09023,0.0382683)
        .setVertex(39,0.0685916,-1.09023,-0.0382683)
        .setVertex(40,0.337566,-1.03892,0.0382683)
        .setVertex(41,0.337566,-1.03892,-0.0382683)
        .setVertex(42,0.585331,-0.922334,0.0382683)
        .setVertex(43,0.585331,-0.922334,-0.0382683)
        .setVertex(44,0.796317,-0.747791,0.0382683)
        .setVertex(45,0.796317,-0.747791,-0.0382683)
        .setVertex(46,0.957267,-0.526262,0.0382683)
        .setVertex(47,0.957267,-0.526262,-0.0382683)
        .setVertex(48,1.05807,-0.271666,0.0382683)
        .setVertex(49,1.05807,-0.271666,-0.0382683)
        .setVertex(50,1.09239,0.00000,0.0382683)
        .setVertex(51,1.09239,0.00000,-0.0382683);


    public Torus(){
        super();
        this.setBgColor(Color.White);

        Model torus = new Model();
        {
            torus.add(new Material(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE, Color.Blue));
            torus.add(new ShadeModel(GL2.GL_FLAT));
            Solid s = new Solid(A)
                .union(new Solid(B))
                .union(new Solid(C))
                .union(new Solid(D))
                .union(new Solid(E))
                .union(new Solid(F))
                .union(new Solid(G))
                .union(new Solid(H));
            torus.add(s);
        }
        this.add(torus);

        this.setFv3Bounds();

        this.defineCamera('A').orthoFront(this);
        this.defineCamera('B').orthoBack(this);
        this.defineCamera('C').orthoTop(this);
        this.defineCamera('D').orthoBottom(this);
        this.defineCamera('E').orthoLeft(this);
        this.defineCamera('F').orthoRight(this);
    }
}
