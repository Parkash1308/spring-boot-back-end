package fullstackdevelopment.controller;

import fullstackdevelopment.model.Publisher;
import fullstackdevelopment.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.hibernate.boot.jaxb.SourceType.URL;


@RestController
@RequestMapping("/api/publisher")


public class PublisherController {
    private final PublisherService publisherService;
    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    @GetMapping
    public List<Publisher> getAllPublishers(){

        return publisherService.findAllPublisher();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> findPublisherById(@PathVariable Long id){
        Optional<Publisher> publisher=publisherService.findPublisherById(id);
        return publisher.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping()
    public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher){
        Publisher savedPublisher =publisherService.savePublisher(publisher);
        return ResponseEntity.created(URI.create("/api/publishers/" + savedPublisher.getPublisherID())).body(savedPublisher);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisherById(@PathVariable Long id){
        publisherService.deletePublisherById(id);
        return ResponseEntity.noContent().build();
    }

}
