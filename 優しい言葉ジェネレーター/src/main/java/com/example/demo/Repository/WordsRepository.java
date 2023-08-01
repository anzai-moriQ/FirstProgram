package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Words;

@Repository
public interface WordsRepository extends JpaRepository<Words, Integer> {
	List<Words> findByWord(String word);
	List<Words> findByStress(int stress);
}