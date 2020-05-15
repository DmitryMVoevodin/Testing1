package com.artezio.testing;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.artezio.testing.Repository.LENGTH_OF_ID;
import static com.artezio.testing.Repository.EMPTY_OBJECT_EXCEPTION_MESSAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class RepositoryTesting {

    private final static String RETURNED_VALUE = "AAAAAAA";

    private static Repository repository;

    @BeforeClass
    public static void createRepository(){
        repository = new Repository();
    }

    @Test
    public void saveWithoutExceptionTesting() throws EmptyObjectException {
        Object obj = new Object();

        IdGenerator idGenerator = new IdGenerator();
        idGenerator.setStringHelper(new StringHelper());
        repository.setIdGenerator(idGenerator);
        String actualResult = repository.save(obj);
        assertNotNull(actualResult);
        assertEquals(LENGTH_OF_ID, actualResult.length());

        idGenerator = EasyMock.createMock(IdGenerator.class);
        EasyMock.expect(idGenerator.generateId(LENGTH_OF_ID)).andReturn(RETURNED_VALUE);
        EasyMock.replay(idGenerator);
        repository.setIdGenerator(idGenerator);
        actualResult = repository.save(obj);
        assertNotNull(actualResult);
        assertEquals(RETURNED_VALUE, actualResult);
        assertTrue(actualResult.equals(RETURNED_VALUE));
        EasyMock.verify(idGenerator);
    }

    @Test
    public void saveWithExceptionTesting() throws EmptyObjectException {
        IdGenerator idGenerator = new IdGenerator();
        idGenerator.setStringHelper(new StringHelper());
        repository.setIdGenerator(idGenerator);
        EmptyObjectException emptyObjectException = assertThrows(EmptyObjectException.class, () -> repository.save(null));
        assertEquals(EMPTY_OBJECT_EXCEPTION_MESSAGE, emptyObjectException.getMessage());
    }

    @Test(expected = EmptyObjectException.class)
    public void saveWithExceptionTesting2() throws EmptyObjectException {
        IdGenerator idGenerator = new IdGenerator();
        idGenerator.setStringHelper(new StringHelper());
        repository.setIdGenerator(idGenerator);
        repository.save(null);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void saveWithExceptionTesting3() throws EmptyObjectException {
        IdGenerator idGenerator = new IdGenerator();
        idGenerator.setStringHelper(new StringHelper());
        repository.setIdGenerator(idGenerator);
        thrown.expect(EmptyObjectException.class);
        thrown.expectMessage(EMPTY_OBJECT_EXCEPTION_MESSAGE);
        repository.save(null);
    }

}
