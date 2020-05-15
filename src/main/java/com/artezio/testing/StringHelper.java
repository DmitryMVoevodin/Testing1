package com.artezio.testing;

import java.util.Random;

public class StringHelper {

    public static String generate(int sizeOfString) {
        String result = "";
        char randomChar;
        Random randomNumber = new Random();
        for(int iteratorNumber = 0; iteratorNumber < sizeOfString; ++iteratorNumber) {
            //randomChar = (char) randomNumber.nextInt((int)Character.MAX_VALUE + 1);
            switch(randomNumber.nextInt(3)) {
                case 0:
                    randomChar = (char) (97 + randomNumber.nextInt(26));
                    break;
                case 1:
                    randomChar = (char) (65 + randomNumber.nextInt(26));
                    break;
                default:
                    randomChar = (char) (48 + randomNumber.nextInt(10));
            }
            result += randomChar;
        }
        return result;
    }

    public String generateNotStatic(int sizeOfString){
        return generate(sizeOfString);
    }

    public static String reverse(String stringArgument){
        if(stringArgument == null) return null;
        String result = "";
        for(int iteratorNumber = stringArgument.length() - 1; iteratorNumber >= 0; --iteratorNumber){
            result += stringArgument.charAt(iteratorNumber);
        }
        return result;
    }

    public static String formating(String stringArgument, String ... arguments){
        if(stringArgument == null) return null;
        if(arguments == null) return null;
        for(String argument : arguments){
            if(argument == null) return null;
        }
        String result = stringArgument;
        for(int iteratorNumber = 0; iteratorNumber < arguments.length; ++iteratorNumber){
            result = result.replaceAll("\\{" + iteratorNumber + "}", arguments[iteratorNumber]);
        }
        return result;
    }

    public static String camelCase(String stringArgument){
        if(stringArgument == null) return null;
        char[] charArray = stringArgument.toLowerCase().toCharArray();
        boolean flagForAlternation = false;
        for(int iteratorNumber = 0; iteratorNumber < charArray.length; ++iteratorNumber){
            if(
                    charArray[iteratorNumber] < 123 &&
                    charArray[iteratorNumber] > 96
            ) {
                charArray[iteratorNumber] -= flagForAlternation?0:32;
                flagForAlternation = !flagForAlternation;
            }
        }
        return new String(charArray);
    }

    public static int methodWithException(int i) throws ExceptionOfNegativeNumber {
        if(i < 0) throw new ExceptionOfNegativeNumber();
        return 0;
    }

    public static void methodWithArithmeticException(){
        int a = 3 / 0;
    }

    public static void methodTimeOut(int m){
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}