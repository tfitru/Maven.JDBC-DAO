package db_tables;

import java.util.List;

interface DAO<T> {


    public T findById(int id);

    public List<T> findAll();

    public T update (T dto);

    public T create(T dto);

    public boolean delete(int id);

}
