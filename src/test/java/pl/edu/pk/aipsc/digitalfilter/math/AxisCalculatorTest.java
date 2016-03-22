package pl.edu.pk.aipsc.digitalfilter.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxisCalculatorTest {

    @Test
    public void shouldGenerateTenPoints() {
        //given
        double start = 0;
        double end = 2;
        double dx = 0.2;

        //when
        double[] result = AxisCalculator.calcAxisArray(start, end, dx);

        //then
        assertEquals(10, result.length);

    }

    @Test
    public void shouldGenerateTenPointsWithStartAtStartAndEndAtEnd() {
        //given
        double start = 0;
        double end = 2;
        double dx = 0.2;

        //when
        double[] result = AxisCalculator.calcAxisArray(start, end, dx);

        //then
        assertEquals(10, result.length);
        assertEquals(0, start, 0.1);
        assertEquals(2, end, 0.1);
    }

}
