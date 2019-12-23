package com.example.demo.Repository;


import com.example.demo.Entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  @Override
  List<User>  findAll();

    public User findByUsername(String username);

    public User findById(Long id);
}