package com.crudapplication;

import javax.persistence.*;

import java.util.*;

@Entity
public class Telefonnummer{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String telefonnummer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    public Telefonnummer(String telefonnummer, Person person){
        this.telefonnummer = telefonnummer;
        this.person = person;
    }


    public String getTelefonnummer(){
        return telefonnummer;
    }

    public Person person(){
        return person;
    }

    public void setPerson(Person person){
        this.person = person;
    }
    public Long getId(){
        return id;
    }

    public void setTelefonnummer(String telefonnummer){
        this.telefonnummer = telefonnummer;
    }
    public Telefonnummer(){
        
    }
}