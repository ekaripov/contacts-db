package ru.ekaripov.contactsdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EventType {
    @Id
    private Long id;
    @Column(nullable = false)
    private String title;
    @OneToOne
    private HistoryType historyType;
}
