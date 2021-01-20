package ru.ekaripov.contactsdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Photo {
    @Id
    private Long id;
    @Column
    private byte[] image;
}
