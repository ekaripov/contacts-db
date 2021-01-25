package ru.ekaripov.contactsdb.model;

import ru.ekaripov.contactsdb.model.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tag {
    @Id
    private Long id;
    @ManyToOne
    private Person person;
    @Column
    private String title;
}
