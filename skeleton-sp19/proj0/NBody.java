public class NBody {

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int first = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
}