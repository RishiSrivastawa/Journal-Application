package xyz.rishi.journalApp.repository;

import org.bson.types.ObjectId;
import xyz.rishi.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
