package com.user.management.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.entity.User;
import com.user.management.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;

	public User updateUser(Long id, User updatedUser) throws ClassNotFoundException, IOException {
        User existingUser = userRepository.findById(id);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        }
        return null; // Return null if user with the given id is not found.
    }

	@Override
	public void deleteUser(Long id) throws ClassNotFoundException, IOException {
		userRepository.delete(id);

	}

	@Override
	public User getUserId(Long id) throws ClassNotFoundException, IOException {
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUser() throws ClassNotFoundException, IOException {
		return userRepository.findAll();
	}

}
