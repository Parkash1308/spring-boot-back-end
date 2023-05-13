package fullstackdevelopment.services;

import fullstackdevelopment.doa.BookCopyRepository;
import fullstackdevelopment.model.BookCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCopyService {
    private  final BookCopyRepository bookCopyRepository;
    @Autowired

    public BookCopyService(BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }
    public List<BookCopy> findAllBookCopies(){
        return bookCopyRepository.findAll();
    }
    public Optional<BookCopy> findBookCopyById(Long id){
       return bookCopyRepository.findById(id);
    }

    public BookCopy savaBookCopy(BookCopy bookCopy){
        return bookCopyRepository.save(bookCopy);
    }

    public void deleteBookCopyById(Long id){
        bookCopyRepository.deleteById(id);
    }
}
