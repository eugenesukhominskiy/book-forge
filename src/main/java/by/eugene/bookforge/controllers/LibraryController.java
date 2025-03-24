package by.eugene.bookforge.controllers;

import by.eugene.bookforge.models.Book;
import by.eugene.bookforge.repository.MemberRepository;
import by.eugene.bookforge.services.BookService;
import by.eugene.bookforge.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBookToLibrary(@RequestParam Long memberId, @RequestParam Long bookId) {
        libraryService.add(memberId, bookId);
        return ResponseEntity.ok().body("Book added to library");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeBookFromLibrary(@RequestParam Long memberId, @RequestParam Long bookId) {
        libraryService.remove(memberId, bookId);
        return ResponseEntity.ok().body("Book removed from library");
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<Book>> getMemberLibrary(@PathVariable Long memberId) {
        return ResponseEntity.ok(libraryService.getLibrary(memberId));
    }
}
