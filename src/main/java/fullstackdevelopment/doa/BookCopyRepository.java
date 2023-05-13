package fullstackdevelopment.doa;

import fullstackdevelopment.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopyRepository extends JpaRepository<BookCopy,Long> {
}
