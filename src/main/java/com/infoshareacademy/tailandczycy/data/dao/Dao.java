package com.infoshareacademy.tailandczycy.data.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    void save();

    void update(T t, String[] params);

    void delete(T t);
}
