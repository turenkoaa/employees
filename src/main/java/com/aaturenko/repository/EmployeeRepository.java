package com.aaturenko.repository;

import com.aaturenko.model.Employee;
import com.aaturenko.model.Organization;
import com.aaturenko.model.Person;
import com.aaturenko.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Anastasia on 16.04.2017.
 */

/*@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
}*/

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    Employee findByPersonAndOrganization(Person person, Organization organization);
}
