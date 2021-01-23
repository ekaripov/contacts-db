package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ekaripov.contactsdb.entities.Person;
import ru.ekaripov.contactsdb.entities.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "history_date")
    private Date historyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_type_id")
    private HistoryType historyType;
}
