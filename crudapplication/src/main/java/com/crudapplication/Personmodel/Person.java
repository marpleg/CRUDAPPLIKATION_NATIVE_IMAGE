package com.crudapplication;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="person")
public class Person{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nachname;
    private String vorname;


    @OneToMany(
        mappedBy = "person",
        cascade = CascadeType.ALL
    )
    private List<Telefonnummer> telefonnummern;

    public Person(){
    }

    public Long getId(){
        return id;
    }

    public String getNachname(){
        return nachname;
    }

    public String getVorname(){
        return vorname;
    }

    public void setNachname(String nachname){
        this.nachname = nachname;
    }

    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public void addTelefonnummern(String[] telefonnummern){
        for(String nummer : telefonnummern){
            this.telefonnummern.add(new Telefonnummer(nummer,this));
        }
    }
    
    public void setTelefonnummern(List<Telefonnummer> newNumbers){
        this.telefonnummern = newNumbers;
    }

    public Person(String nachname,String vorname,String[] nummern){
        this.nachname = nachname;
        this.vorname = vorname;

        this.telefonnummern = new ArrayList<Telefonnummer>();

        for(String nummer:nummern){
            this.telefonnummern.add(new Telefonnummer(nummer,this));
        }
    }
    public Person(String nachname,String vorname,String[] nummern,long id){
        this.nachname = nachname;
        this.vorname = vorname;
        this.id = id;

        this.telefonnummern = new ArrayList<Telefonnummer>();

        for(String nummer:nummern){
            this.telefonnummern.add(new Telefonnummer(nummer,this));
        }
    }

    public List<Telefonnummer> getTelefonnummern(){
        return telefonnummern;
    }

    
}