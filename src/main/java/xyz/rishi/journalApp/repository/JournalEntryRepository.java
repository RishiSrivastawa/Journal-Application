package xyz.rishi.journalApp.repository;

import xyz.rishi.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {

}
