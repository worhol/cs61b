public class NBody {

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.show();

        for (Body planet : readBodies(filename)
        ) {
            planet.draw();

        }

    }

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int first = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String fileName) {
        In in = new In(fileName);
        int first = in.readInt();
        double second = in.readDouble();
        Body[] bodies = new Body[5];
        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = new Body(in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }


        return bodies;

    }
}