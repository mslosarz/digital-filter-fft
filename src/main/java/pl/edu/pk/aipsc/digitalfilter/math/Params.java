package pl.edu.pk.aipsc.digitalfilter.math;

import java.util.Arrays;

public class Params {
    final double[] params;
    final int lenght;

    private Params(double... params) {
        this.params = params;
        this.lenght = params.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(params);
    }

    public static Params create(double... vx) {
        return new Params(Arrays.copyOf(vx, vx.length));
    }

    public double[] copyParams() {
        return Arrays.copyOf(params, lenght);
    }

    public double[] getParams() {
        return params;
    }

    public int getLenght() {
        return lenght;
    }

}
