package xyz.rishi.journalApp.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.rishi.journalApp.entity.JournalEntry;
import xyz.rishi.journalApp.repository.JournalEntryRepository;

import java.util.List;
import java.util.Optional;
// @Component indicates that this class is a Spring-managed component.
// It allows Spring to automatically detect and register the class as a bean in the application context.
@Component
public class JournalEntryService {
    //autowired means that spring will automatically inject the dependency here
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    public void saveEntry(JournalEntry journalEntry){
        //.save() method is provided by MongoRepository to save or update an entity in the database.
        journalEntryRepository.save(journalEntry);
    }
    //.findAll() method is provided by MongoRepository to retrieve all entities from the database.
    // It returns a List of all JournalEntry objects stored in the database.
    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }
    // .findById() method is provided by MongoRepository to retrieve an entity by its unique identifier.
    // optional is a container object which may or may not contain a non-null value.
    // It is used to avoid null pointer exceptions and to represent the presence or absence of a value.
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
