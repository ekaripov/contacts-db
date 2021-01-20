package ru.ekaripov.contactsdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HistoryType {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column(name="show_in_list")
    private boolean showInList;
}
