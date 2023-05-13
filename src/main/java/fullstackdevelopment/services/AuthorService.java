package fullstackdevelopment.services;

import fullstackdevelopment.doa.AuthorRepository;
import fullstackdevelopment.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorService {
    private final AuthorRepository  authorRepository;
    @Autowired

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<Author> findAllAuthor(){
        return authorRepository.findAll();
    }
    public Optional<Author> findAuthorById(Long id){
        return authorRepository.findById(id);
    }

    public Author saveAuthor(Author  author){
        return authorRepository.save(author);
    }
    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }
}
