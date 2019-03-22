package com.example;

import com.example.service.AnalyticalTool;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {

    private AnalyticalTool analyticalTool = new AnalyticalTool();

    @Test
    public void test_OK(){

        String inputData =
                "7 " +
                "C 1.1 8.15.1 P 15.10.2012 83 " +
                "C 1 10.1 P 01.12.2012 65 " +
                "C 1.1 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";

        String expected = "83 100 -";

        assertEquals(expected, analyticalTool.toAppreciate(inputData).trim());

    }

    @Test(expected = Exception.class)
    public void test_invalidNumberOfLines1(){

        String inputData =
                "8 " +
                "C 1.1 8.15.1 P 15.10.2012 83 " +
                "C 1 10.1 P 01.12.2012 65 " +
                "C 1.1 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";

        String expected = "83 100 -";

        assertEquals(expected, analyticalTool.toAppreciate(inputData).trim());

    }

    @Test(expected = Exception.class)
    public void test_invalidNumberOfLines2(){

        String inputData =
                "7 " +
                "C 1.1 8.15.1 P 15.10.2012 83 " +
                "C 1 10.1 P 01.12.2012 65 " +
                "C 1.1 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";

        String expected = "83 100 -";

        assertEquals(expected, analyticalTool.toAppreciate(inputData).trim());

    }

    @Test(expected = AssertionError.class)
    public void test_invalidNumberOfLines(){

        String inputData =
                "7 " +
                "C 2.1 8.15.1 P 15.10.2012 83 " +
                "C 1 10.1 P 01.12.2012 65 " +
                "C 1.1 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";

        String expected = "83 100 -";

        assertEquals(expected, analyticalTool.toAppreciate(inputData).trim());

    }
}
