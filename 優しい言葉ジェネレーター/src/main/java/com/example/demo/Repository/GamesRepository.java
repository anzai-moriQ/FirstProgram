package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer>{
	List<Games> findByGrade(int grade);
}
