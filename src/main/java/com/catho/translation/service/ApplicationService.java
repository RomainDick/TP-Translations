package com.catho.translation.service;

import java.util.Optional;

import com.catho.translation.model.Application;

public interface ApplicationService {

    public Optional<Application> getApplicationbyId(Integer id);

    public Application createApplication(Application application);
}