package com.catho.translation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "translation_id")
    private Integer id;
    
    @NotBlank
    private String language;

    @ManyToOne
    @JoinColumn(name = "application_id")
    @JsonIgnore
    private Application application;

    @OneToMany(mappedBy = "translation", cascade = CascadeType.ALL)
    private List<Entry> entries;
}