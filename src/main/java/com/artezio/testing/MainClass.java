package com.artezio.testing;

public class MainClass {

    public static void main(String[] args) {
        System.out.println(StringHelper.generate(5));
        System.out.println(StringHelper.reverse("hgvv11uhs"));
        System.out.println(StringHelper.formating("To be {0} not {1} - That is the {2}", "or", "to be", "question!"));
        System.out.println(StringHelper.camelCase("hello WORLD!"));
        try {
            System.out.println(StringHelper.methodWithException(-1));
        } catch (ExceptionOfNegativeNumber e) {
            System.out.println(e);
        }
        try {
            StringHelper.methodWithArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        IdGenerator idGenerator = new IdGenerator();
        System.out.println(idGenerator.generateId(5));

    }

}
