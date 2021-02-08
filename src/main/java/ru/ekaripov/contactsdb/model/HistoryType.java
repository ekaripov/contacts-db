package ru.ekaripov.contactsdb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "history_type")
@Data
@NoArgsConstructor
public class HistoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank
    @Size(max = 50)
    private String title;

    @Column(name = "show_in_list", nullable = false)
    @NotBlank
    private boolean showInList;

    @OneToMany(
            mappedBy = "historyType",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<History> historySet = new ArrayList<>();
}
