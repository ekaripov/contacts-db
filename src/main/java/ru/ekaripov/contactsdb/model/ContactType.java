package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact_type")
@Data
@NoArgsConstructor
public class ContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank
    @Size(max = 50)
    private String title;

    @OneToMany(
            mappedBy = "contactType",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Contact> contact = new ArrayList<>();
}
