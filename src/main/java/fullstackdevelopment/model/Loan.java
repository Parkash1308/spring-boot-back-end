package fullstackdevelopment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name="loan")
@Entity
@Getter
@Setter
@ToString
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanID;
    private String borrowerName;

    private LocalDate loanDate;

    @ManyToOne
    @JoinColumn(name = "book_copy_id") // use the name of the column that maps to the book copy ID
    private BookCopy bookCopy;

}
