public class TestBody {
    public static void main(String[] args) {
        test();

    }

    public static void test() {
        Body a = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b = new Body(4.0, 5.0, 1.0, 6.0, 3.0, "jupiter.gif");

        System.out.println(a.calcForceExertedBy(b) + "    " + b.calcForceExertedBy(a));
    }

}
