package ru.ekaripov.contactsdb.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String text;
    @Column
    private String comment;
    @ManyToOne
    private ContactType contactType;
    @ManyToOne
    private Person person;
}
