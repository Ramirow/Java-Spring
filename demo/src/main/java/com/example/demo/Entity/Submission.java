package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="task_id", nullable=false, length=100)
    private long taskid;
    
    @Column(name="user_id", nullable=false, length=100)
    private long userid;

    @NotBlank
    @Column(name="solve",columnDefinition = "TEXT", nullable=false, length=1000)
    private String solve;
    
    @Column(name="subdate", nullable=false, length=100 )
    private String subdate;
}
