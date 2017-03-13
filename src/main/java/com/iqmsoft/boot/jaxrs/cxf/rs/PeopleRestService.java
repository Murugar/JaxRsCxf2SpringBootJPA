package com.iqmsoft.boot.jaxrs.cxf.rs;

import java.util.Collection;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.iqmsoft.boot.jaxrs.cxf.model.Person;
import com.iqmsoft.boot.jaxrs.cxf.repos.PeopleRepository;


@EnableJpaRepositories(basePackages = "com.iqmsoft.boot.jaxrs.cxf.repos")
@ComponentScan(basePackages = "com.iqmsoft.boot.jaxrs.cxf")
@EnableAutoConfiguration
@Path("/people")
@Component
public class PeopleRestService {
	
	@Autowired 
	PeopleRepository peoplerepos;
	
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Person> getPeople() {
        return peoplerepos.findAll();
    }
}
