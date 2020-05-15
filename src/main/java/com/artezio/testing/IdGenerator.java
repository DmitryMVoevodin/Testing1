package com.artezio.testing;

public class IdGenerator {

    private StringHelper stringHelper;

    public void setStringHelper(StringHelper stringHelper) {
        this.stringHelper = stringHelper;
    }

    public String generateId(int lengthOfId){
        return stringHelper.generateNotStatic(lengthOfId);
    }

}
