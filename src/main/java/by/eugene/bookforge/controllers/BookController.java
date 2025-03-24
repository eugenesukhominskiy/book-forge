package by.eugene.bookforge.controllers;

import by.eugene.bookforge.dto.BookDTO;
import by.eugene.bookforge.models.Book;
import by.eugene.bookforge.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/work")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    private ResponseEntity<Book> create(@RequestBody BookDTO book) {
        return ResponseEntity.ok(bookService.create(book));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Book> get(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.read(id));
    }

    //TODO: Method "edit" should be editing by id
    @PatchMapping("/edit")
    private ResponseEntity<Book> edit(@RequestBody BookDTO book) {
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/delete/{id}")
    private HttpStatus delete(@PathVariable Long id) {
        bookService.delete(id);
        return HttpStatus.OK;
    }
}
