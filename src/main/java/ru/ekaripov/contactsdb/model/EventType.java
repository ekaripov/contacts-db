package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "event_types")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank
    private String title;

    @Column(name = "show_in_list", nullable = false)
    private boolean showInList;

    @OneToOne
    @JoinColumn(name = "history_type_id")
    @NotEmpty
    private HistoryType historyType;

    @OneToMany(
            mappedBy = "eventType",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
}
