package pl.edu.pk.aipsc.digitalfilter.window.event;

public class SignalParameters {

    private final double t0;
    private final double t1;
    private final double dt;

    public SignalParameters(double t0, double t1, double dt) {
        this.t0 = t0;
        this.t1 = t1;
        this.dt = dt;
    }

    public double getT0() {
        return t0;
    }

    public double getT1() {
        return t1;
    }

    public double getDt() {
        return dt;
    }

    public static SignalParameters create(String t0, String t1, String dt) {
        return new SignalParameters(Double.parseDouble(t0), Double.parseDouble(t1), Double.parseDouble(dt));
    }

    @Override
    public String toString() {
        return String.format("[%.2f, %.2f] dt = %.6f", t0, t1, dt);
    }

}
