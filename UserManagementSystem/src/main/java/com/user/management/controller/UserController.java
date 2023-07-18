package com.user.management.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.domain.UserDomain;
import com.user.management.entity.User;
import com.user.management.objectcopier.ObjectCopier;
import com.user.management.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Creates a new user account.
     *
     * @param user The user object to be created.
     * @return ResponseEntity containing the created user's information and HTTP status code.
     * @throws IOException  I/O error during the save the data
     */
    @PostMapping()
    public ResponseEntity<UserDomain> createUser(@RequestBody User user) throws IOException {
        User createdUser = userService.createUser(user);
        if (createdUser != null) {
            UserDomain userDomain = new UserDomain();
            ObjectCopier.copyObject(createdUser, userDomain);
            return new ResponseEntity<>(userDomain, HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Retrieves a user by ID.
     *
     * @param id The ID of the user to be retrieved.
     * @return ResponseEntity containing the user's information if found, or HTTP status code 404 if not found.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     * @throws IOException I/O error during the retrieval data
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDomain> getUser(@PathVariable(value = "id") Long id)
            throws ClassNotFoundException, IOException {
        try {
            User user = userService.getUser(id);
            if (user != null) {
                UserDomain userDomain = new UserDomain();
                ObjectCopier.copyObject(user, userDomain);
                return new ResponseEntity<>(userDomain, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retrieves a list of all user accounts.
     *
     * @return ResponseEntity containing a list of user information and HTTP status code.
     * @throws IOException  I/O error during the retrieval process.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     */
    @GetMapping()
    public ResponseEntity<List<UserDomain>> getUsers() throws IOException, ClassNotFoundException {
        List<UserDomain> listuserDomain = new ArrayList<>();
        List<User> listUsers = userService.getUsers();
        if (!listUsers.isEmpty()) {
            for (User user : listUsers) {
                UserDomain userDomain = new UserDomain();
                ObjectCopier.copyObject(user, userDomain);
                userDomain.setId(user.getId());
                userDomain.setUsername(user.getUsername());
                userDomain.setFirstName(user.getFirstName());
                userDomain.setLastName(user.getLastName());
                userDomain.setEmail(user.getEmail());
                listuserDomain.add(userDomain);
            }
        }
        return new ResponseEntity<>(listuserDomain, HttpStatus.OK);
    }
}
