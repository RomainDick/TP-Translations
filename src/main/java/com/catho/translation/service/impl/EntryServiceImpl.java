package com.catho.translation.service.impl;

import java.util.Optional;

import com.catho.translation.model.Entry;
import com.catho.translation.repository.EntryRepository;
import com.catho.translation.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl implements EntryService {
    
    @Autowired
    private EntryRepository entryRepository;

    public Optional<Entry> getEntryById(Integer id) {
        return entryRepository.findById(id);
    }

    public Entry updateEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    public void deleteEntry(Integer id) {
        entryRepository.deleteById(id);
    }
}