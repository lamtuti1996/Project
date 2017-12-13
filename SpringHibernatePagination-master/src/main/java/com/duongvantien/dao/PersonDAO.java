package com.duongvantien.dao;

import com.duongvantien.model.Person;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tienduongvan on 25/03/2017.
 */
public interface PersonDAO extends Serializable {
    public List<Person> findAll(Integer offset, Integer maxResult);
    public Long count();
}
