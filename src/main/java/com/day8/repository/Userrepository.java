package com.day8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day8.model.Users;

public interface Userrepository extends JpaRepository<Users, Integer> {
	
	public List<Users> findByuserName(String name);
}
