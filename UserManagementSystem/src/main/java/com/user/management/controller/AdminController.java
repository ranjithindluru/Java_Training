package com.user.management.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.domain.UserDomain;
import com.user.management.entity.User;
import com.user.management.objectcopier.ObjectCopier;
import com.user.management.service.AdminService;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * Retrieves a list of all user accounts.
     *
     * @return ResponseEntity containing a list of user information and HTTP status code.
     * @throws IOException If there is an I/O error during the retrieval process.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     */
    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> getUsers() throws IOException, ClassNotFoundException {
        List<User> listUsers = adminService.getAllUser();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }

    /**
     * Updates a user account.
     *
     * @param id   The ID of the user to be updated.
     * @param user The user object containing the updated information.
     * @return ResponseEntity containing the updated user's information and HTTP status code.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     * @throws IOException            If there is an I/O error during the update process.
     */
    @PutMapping(value= "/{id}")
    public ResponseEntity<UserDomain> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user)
            throws ClassNotFoundException, IOException {
        try {
            User updatedUser = adminService.updateUser(id, user);
            if (updatedUser != null) {
                UserDomain userDomain = new UserDomain();
                ObjectCopier.copyObject(updatedUser, userDomain);
                return new ResponseEntity<>(userDomain, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a user account.
     *
     * @param id The ID of the user to be deleted.
     * @return ResponseEntity with HTTP status code indicating the success or failure of the deletion.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found during deserialization.
     * @throws IOException            If there is an I/O error during the deletion process.
     */
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteUserId(@PathVariable(value = "id") Long id)
            throws ClassNotFoundException, IOException {
        try {
            adminService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
