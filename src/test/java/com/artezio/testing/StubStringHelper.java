package com.artezio.testing;

public class StubStringHelper extends StringHelper {
    public String generateNotStatic(int sizeOfString){
        String result = "";
        for(int i = 0; i < sizeOfString; ++i) {
            result += 'A';
        }
        return result;
    }
}
