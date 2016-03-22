package pl.edu.pk.aipsc.digitalfilter.math;

public class MulFunction implements Function {
    private Function f1;
    private Function f2;

    private MulFunction(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public Params f(Params p) {
        Params p2 = f2.f(p);
        Params result = Params.create(f1.f(p).params);
        for (int i = 0; i < p.lenght; i++) {
            result.params[i] *= p2.params[i];
        }
        return result;
    }

    public MulFunction mul(Function f1) {
        return new MulFunction(this, f1);
    }

    public static MulFunction mul(Function f1, Function f2) {
        return new MulFunction(f1, f2);
    }

    @Override
    public String toString() {
        return "(" + f1.toString() + " * " + f2.toString() + ")";
    }

}
