package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    @Size(max = 50)
    private String firstName;

    @Column(name = "middle_name")
    @Size(max = 50)
    private String middleName;

    @Column(name = "last_name")
    @Size(max = 50)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "organization")
    @Size(max = 250)
    private String organization;

    @Column(name = "position")
    @Size(max = 250)
    private String position;

    @Column(name = "created")
    @NotBlank
    private LocalDate created;

    @Column(name = "updated")
    @NotBlank
    private LocalDate updated;

    @Column(name = "deleted")
    private LocalDate deleted;

    @Column(name = "comment")
    @Size(max = 250)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private PersonCategory personCategory;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @OneToMany(
            mappedBy = "person",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Tag> tagList = new ArrayList<>();
}
