package com.rauldev.springservices.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rauldev.springservices.entities.User;
import com.rauldev.springservices.repositories.UserRepository;
import com.rauldev.springservices.services.exceptions.DataBaseException;
import com.rauldev.springservices.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
		
	}
	
	public User findById(Long id) {
		
		 Optional<User> obj = repository.findById(id);
		 
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insertUser(User u) {
		return repository.save(u);
	}
	
	public void deleteUser(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User updateUser(Long id,User user) {
		try {
		User  u = repository.getReferenceById(id);
		updateData(u,user);
		return repository.save(u);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User u, User user) {
		u.setPhone(user.getPhone());
		u.setEmail(user.getEmail());
		u.setName(user.getName());
		
	}
}
