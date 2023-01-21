package example.ydzemidovich.messenger.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents one message that is sent in any type of chat by any user.
 */
@Entity
@Table(name = "message")
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    // will create chat_id column (foreign key)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Chat chat;

    // will create author_id column (foreign key)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    private String text;
}
