package de.htw.webtech.SafePass.web;

import de.htw.webtech.SafePass.service.UserService;
import de.htw.webtech.SafePass.web.api.User;
import de.htw.webtech.SafePass.web.api.UserManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<List<User>> fetchUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(path = "/api/v1/users")
    public ResponseEntity<Void> createUser(@RequestBody UserManipulationRequest request) throws URISyntaxException {
        var user = userService.create(request);
        URI uri = new URI("/api/v1/users" + user.getId());
        return ResponseEntity.created(uri).build();
    }
}
