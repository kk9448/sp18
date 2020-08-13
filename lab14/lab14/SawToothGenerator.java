package lab14;

import lab14lib.Generator;
import lab14lib.GeneratorAudioVisualizer;

public class SawToothGenerator implements Generator {
    private double period;
    private int state;
    private double res;

    public SawToothGenerator(int period) {
        state = 0;
        res = 0;
        this.period = period;
    }

    @Override
    public double next() {
        state = (state + 1);
        System.out.println(state % 500);
//        System.out.println(state % 500.0 / 5000);
        double res = -1 +2 * (state % 500.0 / 500);
        return res;
    }

    public static void main(String[] args) {
        /** Your code here. */
        Generator generator = new SawToothGenerator(512);
        GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
        gav.drawAndPlay(4096, 1000000);
    }
}
