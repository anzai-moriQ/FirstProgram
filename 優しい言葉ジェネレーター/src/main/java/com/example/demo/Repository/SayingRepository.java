package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Saying;

@Repository
public interface SayingRepository extends JpaRepository<Saying, Integer>{
}
