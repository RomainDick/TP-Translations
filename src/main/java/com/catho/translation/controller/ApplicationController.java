package com.catho.translation.controller;

import javax.validation.Valid;

import com.catho.translation.model.Application;
import com.catho.translation.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody @Valid Application _application) {
        Application application = applicationService.createApplication(_application);

        return ResponseEntity.status(HttpStatus.CREATED).body(application);
    }
}