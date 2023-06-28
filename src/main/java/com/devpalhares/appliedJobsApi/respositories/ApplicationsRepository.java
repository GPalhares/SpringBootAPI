package com.devpalhares.appliedJobsApi.respositories;

import com.devpalhares.appliedJobsApi.models.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long> {
    List<Applications> findByUser_Id(Long id);

}
