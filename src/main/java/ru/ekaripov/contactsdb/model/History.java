package ru.ekaripov.contactsdb.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "history")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "description")
    @Size(max = 250)
    private String description;

    @Column(name = "history_date")
    @NotBlank
    private LocalDate historyDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "history_type_id")
    private HistoryType historyType;
}
