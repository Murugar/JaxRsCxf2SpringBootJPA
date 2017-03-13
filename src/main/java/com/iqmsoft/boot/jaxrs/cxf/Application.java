package com.iqmsoft.boot.jaxrs.cxf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.iqmsoft.boot.jaxrs.cxf.config.AppConfig;
import com.iqmsoft.boot.jaxrs.cxf.model.Person;
import com.iqmsoft.boot.jaxrs.cxf.repos.PeopleRepository;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.repos")
@ComponentScan(basePackages = "com.example.model")
@EnableAutoConfiguration
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	PeopleRepository peoplerepos;

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		if (peoplerepos.findAll().isEmpty()) {
			
			peoplerepos.save(new Person("a@b.com", "John1", "Smith1"));
			peoplerepos.save(new Person("a@b.com", "John2", "Smith2"));
			peoplerepos.save(new Person("a@b.com", "John3", "Smith3"));
		}
	}
}
