package com.example.demo.Entity;

import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="task_name", nullable=false, length=100)
    private String taskname;

    
    @Column(name="description", nullable=true, length=100)
    private String description;
    
    
}