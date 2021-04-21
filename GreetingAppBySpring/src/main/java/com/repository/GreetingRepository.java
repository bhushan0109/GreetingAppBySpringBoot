package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}