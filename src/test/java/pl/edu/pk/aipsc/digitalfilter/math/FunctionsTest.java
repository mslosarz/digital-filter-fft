package pl.edu.pk.aipsc.digitalfilter.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionsTest {

    Function f1 = new Function() {

        public Params f(Params p) {
            return p;
        }

        @Override
        public String toString() {
            return "x";
        }
    };

    @Test
    public void test1() {
        Params p = Params.create(0, 1, 2, 3, 4);
        System.out.println("IN: " + p);
        SumFunction fn = SumFunction.sum(f1, f1);
        Params result = fn.f(p);
        System.out.println("FUN: " + fn);
        System.out.println("RES: " + result);
        for (int i = 0; i < result.lenght; i++) {
            assertEquals(i * 2, result.params[i], 0.1);
        }

    }

    @Test
    public void test2() {
        Params p = Params.create(0, 1, 2, 3, 4);
        System.out.println("IN: " + p);
        SumFunction fn = SumFunction.sum(f1, f1).sum(f1);
        Params result = fn.f(p);
        System.out.println("FUN: " + fn);
        System.out.println("RES: " + result);
        for (int i = 0; i < result.lenght; i++) {
            assertEquals(i * 3, result.params[i], 0.1);
        }

    }

    @Test
    public void test3() {
        Params p = Params.create(0, 1, 2, 3, 4);
        System.out.println("IN: " + p);
        SumFunction fn = SumFunction.sum(f1, f1).sum(f1);
        MulFunction fm = MulFunction.mul(fn, f1);
        Params result = fm.f(p);
        System.out.println("FUN: " + fm);
        System.out.println("RES: " + result);
        for (int i = 0; i < result.lenght; i++) {
            assertEquals((i + i + i) * i, result.params[i], 0.1);
        }
    }

    @Test
    public void test4() {
        Params p = Params.create(0, 1, 2, 3, 4);
        System.out.println("IN: " + p);
        SumFunction fn = SumFunction.sum(Functions.F1, Functions.F2).sum(Functions.F3);
        MulFunction fm = MulFunction.mul(fn, Functions.F5);
        Params result = fm.f(p);
        System.out.println("FUN: " + fm);
        System.out.println("RES: " + result);
    }

    @Test
    public void test5() {
        double dx = 0.002;
        double x1 = Math.PI / 2;
        int pdx = (int) (x1 / dx);
        double[] x = new double[pdx];
        x[0] = 0;
        for (int i = 1; i < pdx; i++) {
            x[i] = x[i - 1] + dx;
        }
        Params p = Params.create(x);
        System.out.println("IN: " + p);
        SumFunction fn = SumFunction.sum(Functions.F5, f1);
        MulFunction fm = MulFunction.mul(fn, f1);
        Params result = fm.f(p);
        System.out.println("FUN: " + fm);
        System.out.println("RES: " + result);
    }

}
