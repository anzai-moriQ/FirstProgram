package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	List<Users> findByNameAndPassword(String name, String password);
	List<Users> findByName(String name );
}
