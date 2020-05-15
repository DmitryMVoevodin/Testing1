package com.artezio.testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTesting {

    @Parameters(name = "test #{index}: reverse({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"abc","cba"},{"123","321"},{"jsk s","s ksj"},{"",""},{null,null}});
    }

    //Если не используется конструктор, а аннотация @Parameter, тогда поля должны быть public
    @Parameter(0) //Необязательно в этом месте указывать (0)
    public String inputValue;
    @Parameter(1)
    public String expectedValue;

    //Если не используется аннотация @Parameter, нужно использовать конструктор
    /*public ParameterizedTesting(String inputValue, String expectedValue){
        this.inputValue = inputValue;
        this.expectedValue = expectedValue;
    }*/

    @Test
    public void reverseMethodTesting(){
        assertEquals(expectedValue, StringHelper.reverse(inputValue));
        System.out.println("inputValue=" + inputValue + "; result=" + StringHelper.reverse(inputValue) + "; expectedValue=" + expectedValue);
    }

    @BeforeClass
    public static void beforeClassMethod(){
        System.out.println();
        System.out.println("***************************beforeClassMethod()");
        System.out.println();
    }

    @AfterClass
    public static void afterClassMethod(){
        System.out.println();
        System.out.println("***************************afterClassMethod()");
        System.out.println();
    }

    @Before
    public void beforeMethod(){
        System.out.println();
        System.out.println("--beforeMethod()");
    }

    @After
    public void afterMethod(){
        System.out.println("--afterMethod()");
    }

}
