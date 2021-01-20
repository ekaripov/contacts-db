package ru.ekaripov.contactsdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Event {
    @Id
    private Long id;
    @Column(nullable = false)
    private Date eventdate;
    @Column
    private String description;
    @ManyToOne
    private Person person;
    @ManyToOne
    private User user;
    @ManyToOne
    private EventType eventType;
}
