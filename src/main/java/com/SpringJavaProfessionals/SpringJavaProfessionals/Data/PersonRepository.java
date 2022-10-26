package com.SpringJavaProfessionals.SpringJavaProfessionals.Data;

import com.SpringJavaProfessionals.SpringJavaProfessionals.Model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
}
