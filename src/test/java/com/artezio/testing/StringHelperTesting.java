package com.artezio.testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

/*import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;*/
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static org.hamcrest.CoreMatchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringHelperTesting {

    private final int LENGTH_OF_GENERATED_STRING = 5;
    private final String STRING_BEFORE_REVERSE = new String("hgvv11uhs");
    private final String STRING_AFTER_REVERSE = new String("shu11vvgh");
    private final String STRING_FOR_FORMATING = new String("To be {0} not {1} - That is the {2}");
    private final String[] STRING_ARRAY_FOR_FORMATING = new String[]{"or", "to be", "question!"};
    private final String STRING_AFTER_FORMATING = new String("To be or not to be - That is the question!");
    private final String STRING_BEFORE_CAMELCASE = new String("hello WORLD!");
    private final String STRING_AFTER_CAMELCASE = new String("HeLlO wOrLd!");

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

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

    @Ignore("ignoreMethodTesting(): disabled for educational reason.")
    @Test
    public void ignoreMethodTesting(){
        fail();
        System.out.println("--ignoreMethodTesting()");
    }

    public void someNotTestedMethod(){
        fail();
        System.out.println("--someNotTestedMethod()");
    }

    @Test
    public void generateMethodTesting(){
        assertNotNull(StringHelper.generate(LENGTH_OF_GENERATED_STRING));
        assertNotSame(new String(), StringHelper.generate(LENGTH_OF_GENERATED_STRING));
        assertTrue(StringHelper.generate(LENGTH_OF_GENERATED_STRING).length() == LENGTH_OF_GENERATED_STRING);
        assertFalse(StringHelper.generate(LENGTH_OF_GENERATED_STRING).length() != LENGTH_OF_GENERATED_STRING);
        assertEquals(LENGTH_OF_GENERATED_STRING, StringHelper.generate(LENGTH_OF_GENERATED_STRING).length());
        assertEquals(0, StringHelper.generate(-LENGTH_OF_GENERATED_STRING).length());
        assertEquals(0, StringHelper.generate(0).length());
        //fail("generateMethodTesting() failed");
        System.out.println("generateMethodTesting()");
    }

    @Test
    public void reverseMethodTesting(){
        assertNotNull(StringHelper.reverse(STRING_BEFORE_REVERSE));
        assertNull(StringHelper.reverse(null));
        assertNotSame(new String(), StringHelper.reverse(STRING_BEFORE_REVERSE));
        assertTrue(StringHelper.reverse(STRING_BEFORE_REVERSE).equals(STRING_AFTER_REVERSE));
        assertFalse(!StringHelper.reverse(STRING_BEFORE_REVERSE).equals(STRING_AFTER_REVERSE));
        assertEquals(STRING_AFTER_REVERSE, StringHelper.reverse(STRING_BEFORE_REVERSE));
        //fail("reverseMethodTesting() failed");
        System.out.println("reverseMethodTesting()");
    }

    @Test
    public void formatingMethodTesting(){
        assertNotNull(StringHelper.formating(STRING_FOR_FORMATING, STRING_ARRAY_FOR_FORMATING));
        assertNull(StringHelper.formating(null, STRING_ARRAY_FOR_FORMATING));
        assertNull(StringHelper.formating(STRING_FOR_FORMATING, null));
        assertNull(StringHelper.formating(STRING_FOR_FORMATING, STRING_ARRAY_FOR_FORMATING[0], null, STRING_ARRAY_FOR_FORMATING[2]));
        assertNotSame(new String(), StringHelper.formating(STRING_FOR_FORMATING, STRING_ARRAY_FOR_FORMATING));
        assertTrue(StringHelper.formating(STRING_FOR_FORMATING, STRING_ARRAY_FOR_FORMATING).equals(STRING_AFTER_FORMATING));
        assertFalse(!StringHelper.formating(STRING_FOR_FORMATING, STRING_ARRAY_FOR_FORMATING).equals(STRING_AFTER_FORMATING));
        assertEquals(STRING_AFTER_FORMATING, StringHelper.formating(STRING_FOR_FORMATING, STRING_ARRAY_FOR_FORMATING));
        assertArrayEquals(new String[]{"or", "to be", "question!"}, STRING_ARRAY_FOR_FORMATING);
        //fail("formatingMethodTesting() failed");
        System.out.println("formatingMethodTesting()");
    }

    @Test
    public void camelCaseMethodTesting(){
        assertNotNull(StringHelper.camelCase(STRING_BEFORE_CAMELCASE));
        assertNull(StringHelper.camelCase(null));
        assertNotSame(new String(), StringHelper.camelCase(STRING_BEFORE_CAMELCASE));
        assertTrue(StringHelper.camelCase(STRING_BEFORE_CAMELCASE).equals(STRING_AFTER_CAMELCASE));
        assertFalse(!StringHelper.camelCase(STRING_BEFORE_CAMELCASE).equals(STRING_AFTER_CAMELCASE));
        assertEquals(STRING_AFTER_CAMELCASE, StringHelper.camelCase(STRING_BEFORE_CAMELCASE));
        //fail("camelCaseMethodTesting() failed");
        System.out.println("camelCaseMethodTesting()");
    }

    @Test(expected = ExceptionOfNegativeNumber.class)
    public void methodWithExceptionTesting() throws ExceptionOfNegativeNumber {
        System.out.println("methodWithExceptionTesting() - before exception");
        assertNotNull(StringHelper.methodWithException(1));
        ExceptionOfNegativeNumber exOfNegNum = assertThrows(ExceptionOfNegativeNumber.class, ()->StringHelper.methodWithException(-1));
        assertNotNull(StringHelper.methodWithException(-1));
        System.out.println("methodWithExceptionTesting() - after exception");
    }

    @Test(expected = ArithmeticException.class)
    public void methodWithArithmeticExceptionTesting() {
        System.out.println("methodWithArithmeticExceptionTesting() - before exception");
        ArithmeticException arithEx = assertThrows(ArithmeticException.class, ()->StringHelper.methodWithArithmeticException());
        StringHelper.methodWithArithmeticException();
        System.out.println("methodWithArithmeticExceptionTesting() - after exception");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void methodExpectedException() throws ExceptionOfNegativeNumber {
        thrown.expect(ExceptionOfNegativeNumber.class);
        thrown.expectMessage("The number is negative");
        StringHelper.methodWithException(-1);
    }

    @Test(timeout = 400)
    public void methodTimeOutTesting(){
        //StringHelper.methodTimeOut(500);
        StringHelper.methodTimeOut(50);
        System.out.println("methodTimeOutTesting()");
    }
}
