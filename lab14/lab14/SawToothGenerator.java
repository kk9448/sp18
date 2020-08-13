package lab14;

import lab14lib.Generator;
import lab14lib.GeneratorAudioVisualizer;

public class SawToothGenerator implements Generator {
    private double period;
    private int state;

    public SawToothGenerator(int period) {
        state = 0;
        this.period = period;
    }

    @Override
    public double next() {
        state = (state + 1);
        /** 遇到小数问题,如果全部是int型, 计算时可以直接加.0 */
        double res = -1 + 2 * (state % 500.0 / 500);
        return res;
    }

    public static void main(String[] args) {
        /** Your code here. */
        Generator generator = new SawToothGenerator(512);
        GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
        gav.drawAndPlay(4096, 1000000);
    }
}
