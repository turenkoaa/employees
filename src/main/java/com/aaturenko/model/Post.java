package com.aaturenko.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Anastasia on 16.04.2017.
 */
@Entity
public class Post {
    private int id;
    private String name;
    //private Set<Employee> employees;

    public Post() {
    }

    public Post(String name) {
        this.name = name;
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

    /*@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }*/

    @Override
    public String toString() {

        String result = String.format("Post[id=%d, name='%s']%n", id, name);
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
