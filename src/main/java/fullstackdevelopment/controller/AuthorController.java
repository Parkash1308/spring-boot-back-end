package fullstackdevelopment.controller;

import fullstackdevelopment.model.Author;
import fullstackdevelopment.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.hibernate.cfg.AvailableSettings.URL;

@RestController
@RequestMapping("/api/authors")

public class AuthorController {
    private AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.findAllAuthor();
    }
    @GetMapping("/{id}")

    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        Optional<Author> author= authorService.findAuthorById(id);
        return author.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        Author savedAuthor= authorService.saveAuthor(author);
        return ResponseEntity.created(URI.create("/api/books/" + savedAuthor.getAuthorID())).body(savedAuthor);
    }
    @DeleteMapping
    public ResponseEntity<Author> deleteAuthorById(@PathVariable Long id){
        authorService.deleteAuthorById(id);
        return  ResponseEntity.noContent().build();
    }


}
