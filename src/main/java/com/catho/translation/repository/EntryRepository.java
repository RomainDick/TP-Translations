package com.catho.translation.repository;

import com.catho.translation.model.Entry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Integer> {

}