package ru.ekaripov.contactsdb.entities;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String firstsname;
    @Column
    private String middlename;
    @Column
    private String lastname;
    @Column
    private Date dateofbirth;
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
}
