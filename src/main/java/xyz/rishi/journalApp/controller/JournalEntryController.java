package xyz.rishi.journalApp.controller;

import org.springframework.web.bind.annotation.*;
import xyz.rishi.journalApp.entity.JournalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @RestController marks this class as a RESTful web controller.
// It combines @Controller and @ResponseBody, meaning methods return data directly in the response body.
// This annotation is used on classes that handle HTTP requests in a RESTful way.
@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping
    public List<JournalEntry>getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable Long myId){
        journalEntries.remove(myId);
        return true;
    }

    @PutMapping("id/{id}")
    public boolean updateJournalEntry(@PathVariable Long id , @RequestBody JournalEntry myEntry){
        journalEntries.put(id, myEntry);
        return true;
    }

}
