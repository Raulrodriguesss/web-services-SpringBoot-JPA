package com.rauldev.springservices.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rauldev.springservices.entities.User;
import com.rauldev.springservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
		
	}
	
	public User findById(Long id) {
		
		 Optional<User> obj = repository.findById(id);
		 
		return obj.get();
	}
	
	public User insertUser(User u) {
		return repository.save(u);
	}
	
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	public User updateUser(Long id,User user) {
		User  u = repository.getReferenceById(id);
		updateData(u,user);
		return repository.save(u);
		
	}

	private void updateData(User u, User user) {
		u.setPhone(user.getPhone());
		u.setEmail(user.getEmail());
		u.setName(user.getName());
		
	}
}
