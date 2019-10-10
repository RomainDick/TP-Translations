package com.catho.translation.service;

import java.util.Optional;

import com.catho.translation.model.Translation;

import org.springframework.stereotype.Service;

@Service
public interface TranslationService {

    public Optional<Translation> getTranslationById(Integer id);

    public Translation createTranslation(Translation translation);
}