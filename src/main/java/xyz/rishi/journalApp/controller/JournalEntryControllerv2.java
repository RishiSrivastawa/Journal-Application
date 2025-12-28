package xyz.rishi.journalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rishi.journalApp.entity.JournalEntry;
import xyz.rishi.journalApp.service.JournalEntryService;

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
        return null;
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable Long myId){
        return true;
    }

    @PutMapping("id/{id}")
    public boolean updateJournalEntry(@PathVariable Long id , @RequestBody JournalEntry myEntry){
        return true;
    }

}
