package com.example.demo.Service;

import com.example.demo.Repository.TaskRepository;
import java.util.List;
import com.example.demo.Entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(long id) {
        return taskRepository.findById(id);
    }

    public List<Task> TaskNamesStartingWith(String segment) {
        return taskRepository.findByTasknameSegment(segment);
    }

}
