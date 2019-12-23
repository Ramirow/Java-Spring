package com.example.demo.Repository;

import com.example.demo.Entity.Task;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Override
    public List<Task> findAll();
    
    public Task findById(long id);
    
    @Query("select s from Task s where s.taskname LIKE (CONCAT('%',:searchTerm, '%'))")
    List<Task> findByTasknameSegment(@Param("searchTerm") String taskname);
}
