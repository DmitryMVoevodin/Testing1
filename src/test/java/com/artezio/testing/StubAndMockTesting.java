package com.artezio.testing;

import org.easymock.EasyMock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StubAndMockTesting {

    @Test
    public void stubTestingForGenerateIdMethod(){
        IdGenerator idGenerator = new IdGenerator();
        idGenerator.setStringHelper(new StubStringHelper());
        String id = idGenerator.generateId(5);
        assertEquals("AAAAA", id);
        System.out.println(id);
    }

    @Test
    public void mockTestingForGenerateIdMethod(){
        StringHelper stringHelper = EasyMock.createMock(StringHelper.class);
        EasyMock.expect(stringHelper.generateNotStatic(5)).andReturn("AAAAA");
        EasyMock.expect(stringHelper.generateNotStatic(0)).andReturn("");
        EasyMock.expect(stringHelper.generateNotStatic(-5)).andReturn("");
        EasyMock.replay(stringHelper);
        IdGenerator idGenerator = new IdGenerator();
        idGenerator.setStringHelper(stringHelper);
        assertEquals("AAAAA", idGenerator.generateId(5));
        assertEquals("", idGenerator.generateId(0));
        assertEquals("", idGenerator.generateId(-5));
        EasyMock.verify(stringHelper);
    }

}