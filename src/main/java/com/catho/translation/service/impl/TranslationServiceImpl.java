package com.catho.translation.service.impl;

import java.util.Optional;

import com.catho.translation.model.Translation;
import com.catho.translation.repository.TranslationRepository;
import com.catho.translation.service.TranslationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationServiceImpl implements TranslationService  {

    @Autowired
    private TranslationRepository translationRepository;

    public Optional<Translation> getTranslationById(Integer id) {
        return this.translationRepository.findById(id);
    }

    public Translation createTranslation(Translation translation) {
        return this.translationRepository.save(translation);
    }
}