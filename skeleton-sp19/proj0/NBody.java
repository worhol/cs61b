public class NBody {

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int first = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String fileName){
            In in = new In(fileName);
           int first = in.readInt();
           double second = in.readDouble();
           Body[] bodies = new Body[5];
           for(int i=0;i<bodies.length;i++){
               bodies[i]=new Body(in.readDouble(),in.readDouble(),
                   in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
           }


            return bodies;

    }
}