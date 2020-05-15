package com.artezio.testing;

public class Repository {

    public final static int LENGTH_OF_ID = 7;
    public final static String EMPTY_OBJECT_EXCEPTION_MESSAGE = "Entity must not be null";

    private IdGenerator idGenerator;

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public String save(Object obj) throws EmptyObjectException {
        if(obj == null) {
            throw new EmptyObjectException(EMPTY_OBJECT_EXCEPTION_MESSAGE);
        }
        String idOfEntity = idGenerator.generateId(LENGTH_OF_ID);
        System.out.println("The entity with id=" + idOfEntity + " is saved.");
        return idOfEntity;
    }
}