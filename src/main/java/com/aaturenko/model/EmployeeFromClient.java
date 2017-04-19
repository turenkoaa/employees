package com.aaturenko.model;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Anastasia on 17.04.2017.
 */
public class EmployeeFromClient {
    private String surname;
    private String name;
    private String middleName;
    private Integer age;
    private Integer postId;
    private Integer orgId;

    public EmployeeFromClient(){}

    public EmployeeFromClient(String surname,String name,String middleName,Integer age,Integer postId,Integer orgId){
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.age = age;
        this.postId = postId;
        this.orgId = orgId;
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

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int id) {
        this.orgId = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int id) {
        this.postId = id;
    }
}
