package dao;

import java.util.List;

public interface IDao<T> {

     boolean create(T o);
     T getByID(int id);
     List<T> getall();
}
