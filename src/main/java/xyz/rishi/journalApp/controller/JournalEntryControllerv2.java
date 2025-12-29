package xyz.rishi.journalApp.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rishi.journalApp.entity.JournalEntry;
import xyz.rishi.journalApp.service.JournalEntryService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @RestController marks this class as a RESTful web controller.
// It combines @Controller and @ResponseBody, meaning methods return data directly in the response body.
// This annotation is used on classes that handle HTTP requests in a RESTful way.
@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry>getAll(){
        return journalEntryService.getAll();
    }
    //@RequestBody binds the HTTP request body to a Java object.
    // It is used in methods that handle HTTP requests to automatically deserialize JSON or XML data from the request body into Java objects.
    // This is commonly used in POST and PUT requests where the client sends data to the server.
    // In this case, it binds the incoming JSON data to a JournalEntry object.
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }
    //@PathVariable is an annotation used to bind a method parameter to a URI template variable.
    // It is commonly used in RESTful web services to extract values from the URL path.
    // In this case, it binds the value of the "myId" path variable in the URL to the ObjectId parameter of the method.
    // For example, if the URL is /journal/id/123, the value "123" will be bound to the myId parameter.
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return true;
    }
    //we used both @PathVariable and @RequestBody annotations in the updateJournalEntry method.
    // @PathVariable is used to extract the id from the URL path, while @RequestBody is used to bind the incoming JSON data to a JournalEntry object.
    // This allows us to update the journal entry with the specified id using the data provided in the request body.
    // The method first retrieves the existing journal entry by its id.
    // If the entry exists, it updates the title and content fields with the new values provided in the request body,
    // but only if those new values are not null or empty. Finally, it saves the updated entry back to the database and returns the updated entry.
    // This approach ensures that only the fields that are provided in the request body are updated, while the other fields remain unchanged.

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntry(@PathVariable ObjectId id , @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old!=null  ){
            old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals("")?newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() !=null && !newEntry.getContent().equals("")?newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }

}
