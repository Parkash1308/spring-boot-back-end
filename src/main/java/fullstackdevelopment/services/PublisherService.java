package fullstackdevelopment.services;

import fullstackdevelopment.doa.PublisherRepository;
import fullstackdevelopment.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class PublisherService {
    private  final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Autowired


    public List<Publisher> findAllPublisher(){
        return publisherRepository.findAll();
    }
    public Optional<Publisher> findPublisherById(Long id){
        return publisherRepository.findById(id);
    }

    public Publisher savePublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id){
        publisherRepository.deleteById(id);
    }
}
