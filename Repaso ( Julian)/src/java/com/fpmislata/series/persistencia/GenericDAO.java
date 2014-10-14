package com.fpmislata.series.persistencia;

import java.util.List;

//La <T> es para decir que es una interfaz generica
//se puede poner <T> o <Entity> para saber el tipo. Mejor usar T
public interface GenericDAO <T> {
    public abstract T get(int id);
    public abstract T insert(T t);
    public abstract void delete(int id);
    public abstract T update(T t);
    public List<T> findAll();
}
