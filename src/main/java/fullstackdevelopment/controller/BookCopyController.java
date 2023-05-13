package fullstackdevelopment.controller;

import fullstackdevelopment.model.BookCopy;
import fullstackdevelopment.services.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Book-copies")

public class BookCopyController {
    private final BookCopyService bookCopyService;
    @Autowired

    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }
    public List<BookCopy> getAllBookCopies(){
        return bookCopyService.findAllBookCopies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCopy>  getBookCopyById(@PathVariable Long id){
        Optional<BookCopy> bookCopy=bookCopyService.findBookCopyById(id);
        return bookCopy.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookCopy> addBookCopy(@RequestBody BookCopy bookCopy){
        BookCopy savedBookCopy = bookCopyService.savaBookCopy(bookCopy);
        return ResponseEntity.created(URI.create("/api/Book-copies"+savedBookCopy.getBookCopyID())).body(savedBookCopy);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCopyById(@PathVariable Long id){
        bookCopyService.deleteBookCopyById(id);
        return ResponseEntity.noContent().build();
    }
}
