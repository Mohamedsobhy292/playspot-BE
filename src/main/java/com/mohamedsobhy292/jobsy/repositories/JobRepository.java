package com.mohamedsobhy292.jobsy.repositories;

import com.mohamedsobhy292.jobsy.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
