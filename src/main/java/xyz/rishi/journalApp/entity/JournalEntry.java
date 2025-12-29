package xyz.rishi.journalApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
// @Document marks this class as a MongoDB document mapped to the "journal_entries" collection.
@Document(collection = "journal_entries")
public class JournalEntry {
    //the annotation @Id marks this field as the primary key in the MongoDB collection.
    //JsonIgnore will ignore this field during serialization/deserialization.
    @Id
    @JsonIgnore
    private ObjectId id;

    private String title;
    private String content;
    private LocalDateTime date;

    // 🔑 expose id as String in JSON
    @JsonProperty("id")
    public String getIdAsString() {
        // Convert ObjectId to its hexadecimal string representation
        // This makes it easier to work with IDs in client applications
        return id != null ? id.toHexString() : null;
    }

    // getters & setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
