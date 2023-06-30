package com.devpalhares.appliedJobsApi.services;

import com.devpalhares.appliedJobsApi.models.Applications;
import com.devpalhares.appliedJobsApi.models.User;
import com.devpalhares.appliedJobsApi.respositories.ApplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ApplicationsService {
    @Autowired
    private ApplicationsRepository applicationsRepository;
    @Autowired
    private UserService userService;

    public Applications findById(Long id) {
        Optional<Applications> applications = this.applicationsRepository.findById(id);
        return applications.orElseThrow(() -> new RuntimeException(
                "Application not found ID:" + id + "Data Type" + Applications.class.getName()));
    }

    @Transactional
    public Applications create(Applications obj) {
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.applicationsRepository.save(obj);
        return obj;
    }

    @Transactional

    public Applications update(Applications obj) {
        Applications newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        newObj.setDate(obj.getDate());
        newObj.setStatus(obj.getStatus());
        return this.applicationsRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.applicationsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Not possible to delete Application");
        }
    }
}

