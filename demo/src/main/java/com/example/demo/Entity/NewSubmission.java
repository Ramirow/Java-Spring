package com.example.demo.Entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewSubmission {
    
    private long id;
    
    private long taskid;
    
    private String username;
    
    private String solve;
    
    private String subdate;
    
}
