package fullstackdevelopment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name="bookCopy")
@Getter
@Setter
@Entity
@ToString
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookCopyID;
    private String barCode;
    private String condition;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    @OneToOne(mappedBy = "bookCopy")
    private Loan loan;

}
