package com.iqmsoft.boot.jaxrs.cxf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqmsoft.boot.jaxrs.cxf.model.Person;


public interface PeopleRepository extends JpaRepository<Person, Long>{

}
