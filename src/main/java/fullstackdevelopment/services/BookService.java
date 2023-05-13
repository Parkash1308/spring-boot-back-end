package fullstackdevelopment.services;

import fullstackdevelopment.doa.BookRepository;
import fullstackdevelopment.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {


    private BookRepository bookRepository;
    @Autowired

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long bookId){
        return bookRepository.findById(bookId);
    }
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBookById(Long bookId){
        bookRepository.deleteById(bookId);
    }
}
