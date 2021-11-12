package de.htw.webtech.SafePass.web;

import de.htw.webtech.SafePass.web.api.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    private List<User> mockUsers;

    public UserRestController() {
        mockUsers = new ArrayList<>();
        mockUsers.add(new User(1, "John", "Cena", "USA", "60009"));
        mockUsers.add(new User(2, "Tony", "Montana", "Cuba", "10700"));
    }

    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<List<User>> fetchUsers() {
        return ResponseEntity.ok(mockUsers);
    }
}
