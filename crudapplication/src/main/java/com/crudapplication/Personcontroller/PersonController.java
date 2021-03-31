package com.crudapplication;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


import java.lang.Iterable;
import org.springframework.stereotype.Component;



@Controller 
@RequestMapping(path="/person"
)

public class PersonController {
  @Autowired
  private PersonRepository persRep;


  @PostMapping(path="/add",
  consumes = MediaType.APPLICATION_JSON_VALUE) 
  public @ResponseBody String addNewPerson (@RequestBody dto o)  {
    Person p = new Person(o.nachname,o.vorname,o.nummern);
    persRep.save(p);
    return "saved";
  }


  @GetMapping(path="/getall") 
  public @ResponseBody Iterable<Person> getallPeople ()  {
    Iterable <Person> pl = persRep.findAll();
    return  pl;
  }

  @GetMapping(path="/get",
  consumes = MediaType.APPLICATION_JSON_VALUE) 
  public @ResponseBody Person getallPeople (@RequestBody dto o)  {
    Person p = persRep.findById(o.id).get();
    return p;
  }
 @PostMapping(path="/change",
  consumes = MediaType.APPLICATION_JSON_VALUE) 
  public @ResponseBody String changePerson (@RequestBody dto o)  {
    Person p = persRep.findById(o.id).get();

    if(p == null) return "no such Person";

    p.setNachname(o.nachname);
    p.setVorname(o.vorname);
    p.addTelefonnummern(o.nummern);
    persRep.save(p);
    return "saved";
  }

  @DeleteMapping(path="/delete",
  consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody String deletePerson(@RequestBody dto o){
      try
      {
        persRep.deleteById(o.id);
      }
      catch(Exception e){
        return "no such Person";
      }
      return "deleted";
  }

  @Component
  public static class dto{
      public Long id;
      public String vorname;
      public String nachname;
      public String[] nummern;

      public Long getId(){
        return id;
      }

      public String getVorname(){
        return vorname;
      }
      public String getNachname(){
        return nachname;
      }

      public String[] getNummern(){
        return nummern;
      }

      public void setVorname(String vorname){
        this.vorname=vorname;
      }

      public void setNachname(String nachname){
        this.nachname=nachname;
      }
      
      public void setNummern(String[] nummern){
        this.nummern = nummern;
      }

      public void setId(Long id){
        this.id = id;
      }
  }
}