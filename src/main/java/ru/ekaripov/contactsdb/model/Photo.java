package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "photo")
@Data
@NoArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "image", nullable = false)
    @NotBlank
    private byte[] image;

    @OneToOne(mappedBy = "photo", orphanRemoval = true, cascade = CascadeType.ALL)
    private Person person;
}
