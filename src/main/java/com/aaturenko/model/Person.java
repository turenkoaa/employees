package com.aaturenko.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

/**
 * Created by Anastasia on 16.04.2017.
 */
@Entity
public class Person {
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private Integer age;
    //private Set<Employee> employees;

    public Person() {
    }


    public Person(String surname, String name, String middleName, Integer age) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String name) {
        this.surname = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String name) {
        this.middleName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }*/

    @Override
    public String toString() {

        String result = String.format("Person[id=%d, name='%s', surname='%s', middle_name='%s', age='%d']%n", id, name, surname, middleName, age);
        return result;
    }

    public String toJsonString() {

        String result = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            result = mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            result = e.getMessage();
        }

        return result;
    }
}
