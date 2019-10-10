package com.catho.translation.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.catho.translation.model.Entry;
import com.catho.translation.model.Translation;
import com.catho.translation.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applications/{idApp}/translations/{idTranslation}/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping(value = "/{idEntry}")
    public ResponseEntity<Entry> getEntry(@PathVariable("idApp") Integer idApp, @PathVariable("idTranslation") Integer idTranslation, @PathVariable("idEntry") Integer idEntry) {
        Optional<Entry> entryOpt = entryService.getEntryById(idEntry);

        if (entryOpt.isPresent()) {
            Entry entry = entryOpt.get();

            Translation translation = entry.getTranslation();

            if (translation != null && idTranslation.equals(translation.getId())
                && idApp.equals(translation.getApplication().getId())) {
                return ResponseEntity.ok(entry);
            }
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{idEntry}")
    public ResponseEntity<Entry> updateEntry(@RequestBody @Valid Entry _entry, @PathVariable("idEntry") Integer idEntry) {
        Optional<Entry> entryOpt = this.entryService.getEntryById(idEntry);

        if (entryOpt.isPresent()) {
            Entry entry = entryOpt.get();

            entry.setKey(_entry.getKey());
            entry.setValue(_entry.getValue());
            entry = entryService.updateEntry(entry);

            return ResponseEntity.ok(entry);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{idEntry}")
    public ResponseEntity<Void> deleteEntry(@PathVariable("idEntry") Integer idEntry) {
        entryService.deleteEntry(idEntry);
        return ResponseEntity.noContent().build();
    }
}