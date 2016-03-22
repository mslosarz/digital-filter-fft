package pl.edu.pk.aipsc.digitalfilter.math;

public class AxisCalculator {

    private AxisCalculator() {

    }

    public static double[] calcAxisArray(double start, double end, double dx) {
        int pdx = (int) ((end - start) / dx);
        double[] result = new double[pdx];
        for (int i = 0; i < pdx; i++) {
            result[i] = start;
            start += dx;
        }
        return result;
    }

    public static Params calcAxisParams(double start, double end, double dx) {
        return Params.create(calcAxisArray(start, end, dx));
    }

}
