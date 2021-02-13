import java.lang.Math;

public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
//        r2=dx2+dy2
        double dx = Math.pow((this.xxPos - b.xxPos), 2);
        double dy = Math.pow((this.yyPos - b.yyPos), 2);
        return Math.sqrt(dx + dy);
    }

    public static final double g() {
        return 6.67e-11;
    }

    public double calcForceExertedBy(Body b) {
//        G=6.67⋅10−11Nm2kg2
//        F=G⋅m1⋅m2/r2

        return (g() * this.mass * b.mass) / Math.pow(calcDistance(b), 2);

    }

    public double calcForceExertedByX(Body b) {
        return (b.xxPos - this.xxPos) / this.calcDistance(b) * this.calcForceExertedBy(b);

    }

    public double calcForceExertedByY(Body b) {
        return (b.yyPos - this.yyPos) / this.calcDistance(b) * this.calcForceExertedBy(b);

    }

    public double calcNetForceExertedByX(Body[] b) {
        double netSum = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i].mass == this.mass) {
                continue;
            }
            netSum += calcForceExertedByX(b[i]);
        }
        return netSum;
    }

    public double calcNetForceExertedByY(Body[] b) {
        double netSum = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i].mass == this.mass) {
                continue;
            }
            netSum += calcForceExertedByY(b[i]);
        }
        return netSum;
    }
}
