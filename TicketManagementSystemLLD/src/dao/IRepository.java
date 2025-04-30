package dao;

import java.util.Collection;

public interface IRepository<T> {
    void add(T item);
    T get(int id);
    Collection<T> getAll();
}
