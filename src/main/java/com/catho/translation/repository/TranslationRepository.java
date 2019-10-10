package com.catho.translation.repository;

import com.catho.translation.model.Translation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation, Integer> {

}