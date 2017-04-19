package com.aaturenko.service;

import com.aaturenko.model.EmployeeFromClient;

import java.util.Set;

/**
 * Created by Anastasia on 17.04.2017.
 */
public interface DataService {

    public Set<String> getOrgs();

    public Set<String> getPosts();

    public Set<String> getStaff();

    public boolean saveEmployees(EmployeeFromClient employeeFromClient);
}