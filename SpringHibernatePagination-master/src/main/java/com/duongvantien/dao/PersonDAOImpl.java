package com.duongvantien.dao;

import com.duongvantien.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by tienduongvan on 25/03/2017.
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Person> findAll(Integer offset, Integer maxResults) {
        return sessionFactory.openSession()
                .createCriteria(Person.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:10)
                .list();
    }

    @SuppressWarnings("unchecked")
    public Long count() {
        return (Long)sessionFactory.openSession()
                .createCriteria(Person.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }
}
