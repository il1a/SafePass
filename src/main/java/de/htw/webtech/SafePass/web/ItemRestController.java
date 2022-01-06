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

    @GetMapping(path = "/api/v1/items/{id}")
    public ResponseEntity<Item> fetchItemById(@PathVariable Long id) {
        var item = itemService.findById(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/items")
    public ResponseEntity<Void> createItem(@RequestBody ItemManipulationRequest request) throws URISyntaxException {
        var item = itemService.create(request);
        URI uri = new URI("/api/v1/items/" + item.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody ItemManipulationRequest request) {
        var item = itemService.update(id, request);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean successful = itemService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
