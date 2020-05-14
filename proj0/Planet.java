
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.abs;

public class Planet {
    public double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    double calcDistance(Planet x){
//        return 3.0;
        return sqrt((x.xxPos - xxPos) * (x.xxPos - xxPos) + (x.yyPos - yyPos) * (x.yyPos - yyPos));
    }

    double calcForceExertedBy(Planet x) {
       return (G * mass * x.mass)/((x.xxPos - xxPos) * (x.xxPos - xxPos) + (x.yyPos - yyPos) * (x.yyPos - yyPos));
    }

    double calcForceExertedByX(Planet x) {
        double F = (G * mass * x.mass)/((x.xxPos - xxPos) * (x.xxPos - xxPos) + (x.yyPos - yyPos) * (x.yyPos - yyPos));
        return (F * abs(x.xxPos - xxPos))/calcDistance(x);
    }


    double calcForceExertedByY(Planet x) {
        double F = (G * mass * x.mass)/((x.xxPos - xxPos) * (x.xxPos - xxPos) + (x.yyPos - yyPos) * (x.yyPos - yyPos));
        return (F * abs(x.yyPos - yyPos))/calcDistance(x);
    }

    double calcNetForceExertedByX(Planet[] x) {
        double forceX = 0;
        for (int i = 0; i < x.length; i++ ) {
            if (!this.equals(x[i])) {
                forceX = forceX + calcForceExertedByX(x[i]);
            }
        }
        return forceX;
    }
    double calcNetForceExertedByY(Planet[] x) {
        double forceY = 0;
        for (int i = 0; i < x.length; i++ ) {
            if (!this.equals(x[i])) {
                forceY = forceY + calcForceExertedByY(x[i]);
            }
        }
        return forceY;

    }

    void update(double t, double fx, double fy) {
        double avx = fx / mass;
        double avy = fy / mass;
        xxVel = xxVel + avx * t;
        yyVel = yyVel + avy * t;
        xxPos = xxPos + xxVel * t;
        yyPos = yyPos + yyVel * t;

    }

   void draw() {
       StdDraw.picture(xxPos, yyPos, imgFileName);
   }




}
