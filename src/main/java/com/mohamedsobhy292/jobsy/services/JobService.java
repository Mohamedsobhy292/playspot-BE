package com.mohamedsobhy292.jobsy.services;

import com.mohamedsobhy292.jobsy.entities.Job;
import com.mohamedsobhy292.jobsy.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }


}
