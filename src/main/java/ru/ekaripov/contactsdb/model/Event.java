package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "event_date", nullable = false)
    @NotBlank
    private LocalDate eventDate;

    @Column(name = "description")
    @Size(max = 250)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private EventType eventType;
}
