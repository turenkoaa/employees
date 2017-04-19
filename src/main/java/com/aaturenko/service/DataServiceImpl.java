package com.aaturenko.service;

import com.aaturenko.controller.ExceptionHandlerController;
import com.aaturenko.model.*;
import com.aaturenko.repository.EmployeeRepository;
import com.aaturenko.repository.OrganizationRepository;
import com.aaturenko.repository.PersonRepository;
import com.aaturenko.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anastasia on 17.04.2017.
 */
@Service("dataService")
public class DataServiceImpl implements DataService{

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class); //Logger.getLogger(ExceptionHandlerController.class);

    @Autowired
    @Qualifier("employeeRepository")
    private EmployeeRepository employeeRepository;
    @Autowired
    @Qualifier("organizationRepository")
    private OrganizationRepository organizationRepository;
    @Autowired
    @Qualifier("personRepository")
    private PersonRepository personRepository;
    @Autowired
    @Qualifier("postRepository")
    private PostRepository postRepository;

    @Override
    @Transactional
    public Set<String> getOrgs(){
        Set<String> result = new HashSet<>();;
        for (Organization organization: organizationRepository.findAll()) {
            result.add(organization.toJsonString());
        }

        return result;
    }

    @Override
    @Transactional
    public Set<String> getPosts(){
        Set<String> result = new HashSet<>();;
        for (Post post: postRepository.findAll()) {
            result.add(post.toJsonString());
        }
        return result;
    }

    @Override
    @Transactional
    public Set<String> getStaff(){
        Set<String> result = new HashSet<>();
        for (Employee employee: employeeRepository.findAll()) {
            result.add(employee.toJsonString());
        }
        return result;
    }

    @Override
    @Transactional
    public boolean saveEmployees(EmployeeFromClient employee){
        try {
            Person person;
            Post post;
            Organization org;

            post = postRepository.findOne(employee.getPostId());
            org = organizationRepository.findOne(employee.getOrgId());

            person = personRepository.findBySurnameAndNameAndMiddleNameAndAge(employee.getSurname(),employee.getName(),employee.getMiddleName(), employee.getAge());
            if (person == null) {
                person = new Person(employee.getSurname(),employee.getName(),employee.getMiddleName(), employee.getAge());
                personRepository.save(person);
            }

            if (employeeRepository.findByPersonAndOrganization(person, org) == null) {
                employeeRepository.save(new Employee(org, person, post));
                return true;
            }
            else{ return false;}

        } catch (Exception e) {
            LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return false;
        }
    }

}
