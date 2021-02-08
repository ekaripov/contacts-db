package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
public class Contact {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "text", nullable = false)
    @NotBlank
    @Size(max = 50)
    private String text;

    @Column(name = "comment")
    @Size(max = 250)
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private ContactType contactType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;
}
