package ru.ekaripov.contactsdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class HistoryItem {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Person person;
    @ManyToOne
    private HistoryType historyType;
    @Column
    private String description;
    @Column(nullable = false)
    private Date historydate;
}
