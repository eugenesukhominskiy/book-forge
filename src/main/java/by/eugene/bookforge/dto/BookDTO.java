package by.eugene.bookforge.dto;

import by.eugene.bookforge.models.Genre;
import by.eugene.bookforge.models.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String description;
    private Long characters;
    private Integer price;
    private Long genreId;
    private Long authorId;
}
