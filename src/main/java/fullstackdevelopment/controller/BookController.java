package fullstackdevelopment.controller;

import fullstackdevelopment.model.Book;
import fullstackdevelopment.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.hibernate.cfg.AvailableSettings.URL;

@RestController
@RequestMapping("api/books")

public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookBYId(@PathVariable Long id){
        Optional<Book> book=bookService.findBookById(id);
        return book.map(ResponseEntity :: ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public  ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook =bookService.saveBook(book);
        return ResponseEntity.created(URI.create("/api/books/" + savedBook.getBookID())).body(savedBook);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
