package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column
    private String organization;
    @Column
    private String position;
    @Column(nullable = false)
    private Date created;
    @Column(nullable = false)
    private Date updated;
    @Column
    private Date deleted;
    @Column
    private String comment;
    @ManyToOne
    private PersonCategory personCategory;
    @OneToOne
    private Photo photo;
}
