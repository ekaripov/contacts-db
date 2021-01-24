package ru.ekaripov.contactsdb.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contact_type")
@Data
public class ContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "contactType", fetch = FetchType.LAZY)
    private Set<Contact> contact;
}
