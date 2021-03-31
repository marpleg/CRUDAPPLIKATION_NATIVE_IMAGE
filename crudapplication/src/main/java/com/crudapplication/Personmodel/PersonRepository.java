package com.crudapplication;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

  Person findById(long id);
  long deleteById(long id);
}