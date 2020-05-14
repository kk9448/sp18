import examples.StdDraw;

public class NBody {

    public static double readRadius(String x) {
        In in = new In(x);

        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;

    }

    public static Planet[] readPlanets(String x) {
        In in = new In(x);
        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();
        int i = 0;
        Planet[] ans = new Planet[numberOfPlanets];
        while (i < numberOfPlanets) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            ans[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
//            ans[i](xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
            i++;
        }
        return ans;

    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        Planet[] planets = readPlanets(args[2]);
        double radius = readRadius(args[2]);
        StdDraw.enableDoubleBuffering();
//        Planet[] res = readPlanets("data/planets.txt");
        String background = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        examples.StdDraw.picture(0, 0, background);
//        StdDraw.show();
//        StdDraw.picture(0, 0, "images/earth.gif");
//        planets[0].draw();
//
//        for (int i = 0; i < planets.length; i++) {
//            planets[i].draw();
//        }

        double time = 0;
        double[] xForce = new double[planets.length];
        double[] yForce = new double[planets.length];
        for (; time < T; ) {
            for (int i = 0; i < planets.length; i++) {
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForce[i], yForce[i]);

            }
            StdDraw.picture(0, 0, background);
            for (int j = 0; j < planets.length; j++) {
                planets[j].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time = time + dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }




    }



}
