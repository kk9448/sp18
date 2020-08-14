package lab14;

import lab14lib.Generator;
import lab14lib.GeneratorAudioVisualizer;

public class AcceleratingSawToothGenerator implements Generator {
    private double period;
    private int state;
    double factor;

    public AcceleratingSawToothGenerator(double period, double x) {
        state = 0;
        this.period = period;
        factor = x;
    }

    @Override
    public double next() {
        state = (state + 1);
        state = state % (int) period;
        if (state == 0) {
            period = period * factor;
        }
        return normalize(state);
    }

    private double normalize(int x) {
        double res = -1 + 2 / period * x;
        return res;
    }

    public static void main(String[] args) {
        /** Your code here. */
        Generator generator = new AcceleratingSawToothGenerator(200, 1.1);
        GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
        gav.drawAndPlay(4096, 1000000);
    }



}
