package ru.ekaripov.contactsdb.model;

import javax.persistence.*;

@Entity
@Table(name="person_category")
public class PersonCategory {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
}
