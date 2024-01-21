package com.example.datajpa.dao;

import com.example.datajpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements  StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional // as we are storing or updating the object in db, handles transaction management
    public void save(Student thestudent) {
        //to save a student using persist(student object);
        entityManager.persist(thestudent);

    }
    @Override
    public Student findById(int studentId) {
        //to retrieve student of particular id : find(Entity classname, primarykey) and if the student is not found with
        //particular id then it returns null and here we are not adding Transactional annotation because we are just reading it and not doing any operations
        return entityManager.find(Student.class, studentId);

    }

    @Override
    public List<Student> findAll() {
        //to get all students using query (JPA Query language) - create query
        TypedQuery<Student> theresults= entityManager.createQuery("FROM Student order by lastName", Student.class);
       //by default sorts asc but we can explicitly mention by order by lastName desc or asc
        // return query results
        return theresults.getResultList();
        /* some more queries examples
        TypedQuery<Student> theresults= entityManager.createQuery("FROM Student", Student.class); - gets list of all students
        TypedQuery<Student> theresults= entityManager.createQuery("FROM Student WHERE lastName='Harry' OR firstName='Potter'", Student.class);
        TypedQuery<Student> theresults= entityManager.createQuery("FROM Student WHERE email LIKE '%luv2code.com", Student.class); - returns list of students have email ending with luv2code.com
         */
    }

    @Override
    public List<Student> listbylastname(String lastName) {
        //JPQL-Named Parameters: where the lastName is passed as parameter to the method and we are using that parameter to query
        //to get the students list filtered by last name
        TypedQuery<Student> lastnamequery= entityManager.createQuery("FROM Student where lastName=:theData", Student.class);
        lastnamequery.setParameter("theData", lastName);
        return lastnamequery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        //to update a student using merge(student object)
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int bulkUpdate() {
        //to update the students in bulk fashion using query and performing executeUpdate()
        //here n is the number of updated rows
        int n= entityManager.createQuery("UPDATE Student SET lastName='Tester'").executeUpdate();
        return n;
    }

    @Override
    @Transactional
    public void delete(int id) {
        //to delete a student using remove(studentobject)
        //retrieve the student
        Student student = entityManager.find(Student.class, 1);
        //delete the student
        entityManager.remove(student);

    }

    @Override
    //using transactional annotation to keep the update operations safe
    @Transactional
    public int deleteAll() {
        //to delete all students using update functionality and here n is the number of delete rows
        int n=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return n;

    }

}
