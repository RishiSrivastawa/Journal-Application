package xyz.rishi.journalApp.repository;

import org.bson.types.ObjectId;
import xyz.rishi.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
// MongoRepository provides CRUD operations for MongoDB.
// It takes two parameters: the entity type and the ID type.
// By extending MongoRepository, JournalEntryRepository inherits methods like save, findAll, findById, deleteById, etc.
// This interface allows interaction with the "journal_entries" collection in MongoDB.
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
