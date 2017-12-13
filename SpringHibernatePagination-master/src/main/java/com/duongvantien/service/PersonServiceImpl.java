package com.duongvantien.service;

import com.duongvantien.dao.PersonDAO;
import com.duongvantien.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tienduongvan on 25/03/2017.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    public List<Person> findAll(Integer offset, Integer maxResult) {
        return personDAO.findAll(offset, maxResult);
    }

    public Long count() {
        return personDAO.count();
    }
}
