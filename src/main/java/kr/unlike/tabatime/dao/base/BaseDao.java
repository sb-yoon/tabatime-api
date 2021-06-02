package kr.unlike.tabatime.dao.base;

import java.util.List;

public interface BaseDao<T> {
    List<T> find();
    T findOne(Integer id);
    int insert(T t);
    int update(T t);
    int delete(Integer id);
}
