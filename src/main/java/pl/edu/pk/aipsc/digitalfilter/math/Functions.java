package pl.edu.pk.aipsc.digitalfilter.math;

import static java.lang.Math.sin;

public enum Functions implements Function {

    F1("32*sin(32*2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = 32 * sin(64 * Math.PI * p.params[i]);
            }
            return Params.create(result);
        }
    },
    F2("2*sin(2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = 2 * sin(Math.PI * p.params[i]);
            }
            return Params.create(result);
        }
    },
    F3("12*sin(64*2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = 12 * sin(128 * Math.PI * p.params[i]);
            }
            return Params.create(result);
        }
    },
    F4("sin(32*2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = sin(64 * Math.PI * p.params[i]);
            }
            return Params.create(result);
        }
    },
    F5("sin(38*2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = sin(72 * Math.PI * p.params[i]);
            }
            return Params.create(result);
        }
    },
    F6("sin(40*2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = sin(80 * Math.PI * p.params[i]);
            }
            return Params.create(result);
        }
    },
    F7("sin(70*2*PI*x)") {
        @Override
        public Params f(Params p) {
            double[] result = new double[p.lenght];
            for (int i = 0; i < p.lenght; i++) {
                result[i] = sin(140 * Math.PI * p.params[i]);
            }
            return Params.create(result);
        }
    };

    private String name;

    private Functions(String name) {
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
