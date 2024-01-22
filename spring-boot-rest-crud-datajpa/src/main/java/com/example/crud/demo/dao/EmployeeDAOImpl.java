package com.example.crud.demo.dao;

import com.example.crud.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //define field for entity manager
    private EntityManager entityManager;
    //perform constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    //implement necessary methods
    //returns the list of Employees
    @Override
    public List<Employee> findAll() {
        //create the query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);
        //get the results and return them
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        //get employee
        Employee employee = entityManager.find(Employee.class, id);
        //return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //save employee
        Employee theemp = entityManager.merge(employee);
        //if the id of the employee is 0 then it will insert the passed employee in db or else it will update the
        //employee if the employee is existing
        //return saved employee
        return theemp;
    }

    @Override
    public void deleteById(int id) {
        //find employee by id
        Employee theemp= entityManager.find(Employee.class, id);
        //remove employee
        entityManager.remove(theemp);
    }


}
