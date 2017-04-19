package com.aaturenko.repository;

import com.aaturenko.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Anastasia on 17.04.2017.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findBySurnameAndNameAndMiddleNameAndAge(String surname, String name, String middleName, Integer age);
}