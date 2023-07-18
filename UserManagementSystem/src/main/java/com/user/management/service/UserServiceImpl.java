package com.user.management.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.entity.User;
import com.user.management.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a new user account and saves it to the file-based storage.
     *
     * @param user The user object the new user account.
     * @return The user object saved.
     * @throws IOException I/O error save process.
     */
    public User createUser(User user) throws IOException {
        user.setId(System.currentTimeMillis());
        return userRepository.save(user);
    }

    /**
     * Retrieves a user account by its ID from the file-based storage.
     *
     * @param id The ID of the user account to be retrieved.
     * @return The userId
     * @throws IOException     I/O error during the retrieval process.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     */
    public User getUser(Long id) throws IOException, ClassNotFoundException {
        return userRepository.findById(id);
    }

    /**
     * Retrieves a list of all user accounts from the file-based storage.
     *
     * @return A list of user objects representing all user accounts.
     * @throws IOException        I/O error during the retrieval process.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     */
    public List<User> getUsers() throws IOException, ClassNotFoundException {
        return userRepository.findAll();
    }

    /**
     * Updates an existing user account in the file-based storage.
     *
     * @param id   The ID of the user account to be updated.
     * @param user The user object updated user.
     * @return The user object
     * @throws IOException            If there is an I/O error during the update process.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     */
    @Override
    public User updateUser(Long id, User user) throws IOException, ClassNotFoundException {
        User userDomain = userRepository.findById(id);
        if (userDomain != null) {
            user.setId(id);
            userRepository.save(user); 
            return user;
        }
        return null;
    }

    /**
     * Deletes a user account by its ID from the file-based storage.
     *
     * @param id The ID of the user account to be deleted.
     * @throws IOException   I/O error during the deletion process.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     */
    @Override
    public void deleteUser(Long id) throws ClassNotFoundException, IOException {
        userRepository.delete(id);
    }
}
