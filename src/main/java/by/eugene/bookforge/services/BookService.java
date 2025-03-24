package by.eugene.bookforge.services;

import by.eugene.bookforge.dto.BookDTO;
import by.eugene.bookforge.models.Book;
import by.eugene.bookforge.models.Genre;
import by.eugene.bookforge.models.Member;
import by.eugene.bookforge.repository.BookRepository;
import by.eugene.bookforge.repository.GenreRepository;
import by.eugene.bookforge.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public BookService(BookRepository bookRepository, GenreRepository genreRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.memberRepository = memberRepository;
    }

    public Book create(BookDTO bookDTO) {
        Genre genre = genreRepository.findById(bookDTO.getGenreId()).orElseThrow(() -> new RuntimeException("Genre not found"));
        Member author = memberRepository.findById(bookDTO.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = Book.builder()
                .title(bookDTO.getTitle())
                .description(bookDTO.getDescription())
                .characters(bookDTO.getCharacters())
                .price(bookDTO.getPrice())
                .genre(genre)
                .author(author)
                .build();
        return bookRepository.save(book);
    }

    public Book read(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book update(BookDTO bookDTO) {
        Genre genre = genreRepository.findById(bookDTO.getGenreId()).orElseThrow(() -> new RuntimeException("Genre not found"));
        Member author = memberRepository.findById(bookDTO.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = Book.builder()
                .title(bookDTO.getTitle())
                .description(bookDTO.getDescription())
                .characters(bookDTO.getCharacters())
                .price(bookDTO.getPrice())
                .genre(genre)
                .author(author)
                .build();
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
