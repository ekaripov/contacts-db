package ru.ekaripov.contactsdb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Data
public class Contact {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private ContactType contactType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;
}
