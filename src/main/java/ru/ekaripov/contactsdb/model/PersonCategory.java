package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person_category")
@Data
@NoArgsConstructor
public class PersonCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String title;

    @OneToMany(
            mappedBy = "personCategory",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Person> personList = new ArrayList<>();
}