package fullstackdevelopment.doa;

import fullstackdevelopment.model.Loan;
import fullstackdevelopment.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
