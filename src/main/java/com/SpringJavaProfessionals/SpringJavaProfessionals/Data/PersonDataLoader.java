package com.SpringJavaProfessionals.SpringJavaProfessionals.Data;

import com.SpringJavaProfessionals.SpringJavaProfessionals.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
public class PersonDataLoader implements ApplicationRunner {

    @Autowired
    private PersonRepository personRepository;

//    @Autowired
//    public PersonDataLoader(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
//                    new Person(null, "Jake", "Snake", LocalDate.of(1950,1,1), "email@sample.com", new BigDecimal(9000)),
//                    new Person(null, "Tobias", "Wander", LocalDate.of(1970,2,15), "", new BigDecimal(7000)),
//                    new Person(null, "Felicia", "Prime", LocalDate.of(1940,10,27), "", new BigDecimal(9000)),
//                    new Person(null, "Martin", "Akita", LocalDate.of(1940,10,27), "", new BigDecimal(9000))
            );
            personRepository.saveAll(people);
        }
    }
}
