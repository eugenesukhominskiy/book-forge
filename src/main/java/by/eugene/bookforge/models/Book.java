package by.eugene.bookforge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;
    @Length(min = 1, max = 500, message = "The pages of the book must be in the range (1-500)")
    @Column(nullable = false)
    private Integer pages;
    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private Long likes;

    @Column(name = "added_at", nullable = false, updatable = false)
    private LocalDateTime addedAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "author_id" , nullable = false)
    private Member author;
    @ManyToMany(mappedBy = "library")
    private List<Member> readers;

    @PrePersist
    protected void onCreate() {
        addedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
