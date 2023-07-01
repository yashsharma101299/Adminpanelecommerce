package com.day8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day8.model.Users;
import com.day8.repository.Userrepository;
@Service
public class Userservice {
	@Autowired
	private Userrepository ur;
	
	public List<Users> allusers()
	{
		List<Users> findAll = ur.findAll();
		return findAll;
	}
	
	public void addnewuser(Users user) 
	{
		ur.save(user);
	}
	public void removeuser(int id) 
	{
		ur.deleteById(id);
	}
	
	public List<Users> usersbyname(String name)
	{
		List<Users> findbyName = ur.findByuserName(name);
		return  findbyName;
	}

}
