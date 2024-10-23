package com.nandini.dao;

import com.nandini.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);

    //ADD NEW METHOD TO READ DATA FROM DATABASE USING PRIMARY KEY
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
