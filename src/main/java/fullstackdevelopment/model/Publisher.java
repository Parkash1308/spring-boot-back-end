package fullstackdevelopment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Table(name="publisher")
@Entity
@Getter
@Setter
@ToString
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publisherID;
    private String name;
    private String location;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

}
