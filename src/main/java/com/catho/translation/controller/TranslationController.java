package com.catho.translation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.catho.translation.model.Application;
import com.catho.translation.model.Entry;
import com.catho.translation.model.Translation;
import com.catho.translation.service.ApplicationService;
import com.catho.translation.service.TranslationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applications/{idApp}/translations")
public class TranslationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private TranslationService translationService;

    @PostMapping
    public ResponseEntity<Translation> createTranslation(@RequestBody @Valid Translation _translation, @PathVariable("idApp") Integer idApp) {
        Optional<Application> app = this.applicationService.getApplicationbyId(idApp);

        if (app.isPresent()) {
            _translation.setApplication(app.get());
            
            List<Entry> entries = _translation.getEntries();

            for (Entry entry : entries) {
                entry.setTranslation(_translation);
            }

            Translation translation = translationService.createTranslation(_translation);

            return ResponseEntity.status(HttpStatus.CREATED).body(translation);
        }
        return ResponseEntity.notFound().build();
    }

}