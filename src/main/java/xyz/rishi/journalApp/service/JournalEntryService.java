package xyz.rishi.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.rishi.journalApp.entity.JournalEntry;
import xyz.rishi.journalApp.repository.JournalEntryRepository;
@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
}
