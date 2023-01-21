package example.ydzemidovich.messenger.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @NotNull
    private String password;

    @NotNull
    private String email;

    private String firstName;

    private String lastName;

    private boolean isBlocked = false;

    @ManyToMany(mappedBy = "users")
    private Set<Chat> chats = new HashSet<>();

    // messages written by this user in any chat
    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Message> userMessages = new HashSet<>();
}
