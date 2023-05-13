
package fullstackdevelopment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table (name="Author")
@Entity
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorID;
    private String name;
    private String nationality;
    private LocalDate dateOfBirth;
    @Column
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;


}
