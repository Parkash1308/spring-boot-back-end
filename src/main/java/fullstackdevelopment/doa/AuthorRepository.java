package fullstackdevelopment.doa;

import fullstackdevelopment.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
