package com.aaturenko.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

/**
 * Created by Anastasia on 16.04.2017.
 */
@Entity
public class Employee {

    private int id;
    private Organization organization;
    private Post post;
    private Person person;

    public Employee() {
    }

    public Employee(Organization organization, Person person, Post post) {
        this.organization = organization;
        this.post = post;
        this.person = person;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "organization_id")
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @ManyToOne
    @JoinColumn(name = "post_id")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String toString() {
        String result = String.format(
                "Employee[id=%d, person='%s', organization='%s', post='%s']%n",
                id, person.getSurname(), organization.getName(), post.getName());

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
