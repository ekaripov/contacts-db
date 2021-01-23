package ru.ekaripov.contactsdb.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contact_type")
@Data
public class ContactType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
}
