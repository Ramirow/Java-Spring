package com.example.demo.Repository;

import com.example.demo.Entity.Submission;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Override
    List<Submission> findAll();

    public List<Submission> findByTaskid(long id);

}
