package com.aaturenko.repository;


import com.aaturenko.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Anastasia on 17.04.2017.
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}