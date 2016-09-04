package com.marks.finance.moneyinthepocket.core.dao.interfaces;

import java.util.List;

/**
 * Created by Alexander on 9/4/2016.
 */
public interface CommonDAO<T> {

    List<T> getAll();
    T get(long id);
    boolean update(T storage);
    boolean delete(T storage);

}
