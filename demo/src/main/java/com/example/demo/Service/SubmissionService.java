package com.example.demo.Service;

import com.example.demo.Entity.Submission;
import com.example.demo.Repository.SubmissionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository subRepository;

    public List<Submission> findAll() {
        return subRepository.findAll();

    }
    
    public Submission save(Submission submission){
        return subRepository.save(submission);
    }

    public List<Submission> findByTaskid(long id) {
        return subRepository.findByTaskid(id);
    }
}
