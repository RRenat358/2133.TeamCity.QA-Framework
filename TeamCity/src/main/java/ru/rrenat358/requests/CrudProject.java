package ru.rrenat358.requests;

public interface CrudProject {

    public Object create(Object object);

    public Object get(Object string);

    public Object update(Object id, Object object);

    public Object delete(Object object);


}
