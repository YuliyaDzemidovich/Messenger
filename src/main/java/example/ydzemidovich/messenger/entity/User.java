package example.ydzemidovich.messenger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * User entity that stores information about the end user.
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotNull
    private String login;
    @Column
    @NotNull
    private String password;
    @Column
    @NotNull
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private boolean isBlocked = false;
}
