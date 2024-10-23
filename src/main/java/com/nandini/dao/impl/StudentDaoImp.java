package com.nandini.dao.impl;

import com.nandini.dao.StudentDao;
import com.nandini.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDaoImp implements StudentDao {

    private final EntityManager entityManager;


    //implements save method
    @Override
    @Transactional
    public void save(Student theStudent) {
     //saves the student in database
     entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
        //TypedQuery<Student> Query = entityManager.createQuery("From Student order by lastName asc",Student.class);

        return theQuery.getResultList();
        //return Query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData",Student.class);

        //set query parameters
        theQuery.setParameter("theData",  theLastName);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
         Student theStudent = entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE From Student").executeUpdate();
    }

}
