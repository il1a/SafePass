package de.htw.webtech.SafePass.web;

import de.htw.webtech.SafePass.service.ItemService;
import de.htw.webtech.SafePass.web.api.Item;
import de.htw.webtech.SafePass.web.api.ItemManipulationRequest;
import de.htw.webtech.SafePass.web.api.User;
import de.htw.webtech.SafePass.web.api.UserManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/api/v1/items")
    public ResponseEntity<List<Item>> fetchItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @PostMapping(path = "/api/v1/items")
    public ResponseEntity<Void> createItem(@RequestBody ItemManipulationRequest request) throws URISyntaxException {
        var item = itemService.create(request);
        URI uri = new URI("/api/v1/items/" + item.getId());
        return ResponseEntity.created(uri).build();
    }

//    @PutMapping(path = "/api/v1/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserManipulationRequest request) {
//        var user = userService.update(id, request);
//        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping(path = "/api/v1/users/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        boolean successful = userService.deleteById(id);
//        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
//    }
}
