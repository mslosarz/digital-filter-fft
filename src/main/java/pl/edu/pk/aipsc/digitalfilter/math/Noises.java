package pl.edu.pk.aipsc.digitalfilter.math;

import java.security.SecureRandom;

import static java.lang.Math.PI;
import static java.lang.Math.sin;

public enum Noises implements Function {
    N1("rand(10)*sin(2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = rand.nextDouble() * 10 * sin(2 * PI * p.params[i]);
            }
            return Params.create(result);
        }
    },
    N2("rand(30)*sin(50*2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = rand.nextDouble() * 30 * sin(100 * PI * p.params[i]);
            }
            return Params.create(result);
        }
    },
    N3("rand(40)") {
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = rand.nextDouble() * 40;
            }
            return Params.create(result);
        }
    };

    private static SecureRandom rand = new SecureRandom();

    private String name;

    private Noises(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Params f(Params p);

    @Override
    public String toString() {
        return getName();
    }

}
