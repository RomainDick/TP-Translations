package com.catho.translation.service.impl;

import java.util.Optional;

import com.catho.translation.model.Application;
import com.catho.translation.repository.ApplicationRepository;
import com.catho.translation.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Optional<Application> getApplicationbyId(Integer id) {
        return this.applicationRepository.findById(id);
    }

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }
}