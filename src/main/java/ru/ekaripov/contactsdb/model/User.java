package ru.ekaripov.contactsdb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Data
@ApiModel(description = "The class represents the user of the application")
public class User {
    @ApiModelProperty(notes = "Unique identifier of the User", required = true, position = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ApiModelProperty(notes = "username is used to for authentication", example = "pivanov", required = true, position = 1)
    @Size(max = 16)
    @NotBlank
    @Column(name = "username",
            unique = true,
            nullable = false)
    private String username;

    @ApiModelProperty(notes = "Full name of user", example = "Ivanov Petr", required = true, position = 2)
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ApiModelProperty(notes = "password of user, must be between 8-16 chars", required = true, position = 3)
    @NotBlank
    @Size(max = 16, min = 8)
    @Column(name = "password", nullable = false)
    private String password;

    @ApiModelProperty(notes = "Status of user account. Boolean", example = "enabled or disabled", required = true, position = 4)
    @NotBlank
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ApiModelProperty(notes = "User authorities", example = "ADMIN", required = true, position = 5)
    @NotBlank
    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private Authorities authorities;

}
