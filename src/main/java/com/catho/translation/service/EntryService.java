package com.catho.translation.service;

import java.util.Optional;

import com.catho.translation.model.Entry;

public interface EntryService {

    public Optional<Entry> getEntryById(Integer id);

    public Entry updateEntry(Entry entry);

    public void deleteEntry(Integer id);
}