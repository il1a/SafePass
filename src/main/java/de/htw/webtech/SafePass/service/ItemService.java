package de.htw.webtech.SafePass.service;

import de.htw.webtech.SafePass.persistence.ItemEntity;
import de.htw.webtech.SafePass.persistence.ItemRepository;
import de.htw.webtech.SafePass.persistence.UserRepository;
import de.htw.webtech.SafePass.persistence.UserRole;
import de.htw.webtech.SafePass.web.api.Item;
import de.htw.webtech.SafePass.web.api.ItemManipulationRequest;
import de.htw.webtech.SafePass.web.api.User;
import de.htw.webtech.SafePass.web.api.UserManipulationRequest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final UserTransformer userTransformer;

    public ItemService(ItemRepository itemRepository, UserRepository userRepository, UserTransformer userTransformer) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    public List<Item> findAll() {
        List<ItemEntity> items = itemRepository.findAll();
        return items.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Item findById(Long id) {
        var userEntity = itemRepository.findById(id);
        return userEntity.map(this::transformEntity).orElse(null);
    }

    public Item create(ItemManipulationRequest request) {
        var holder = userRepository.findById(request.getHolderId()).orElseThrow();
        var itemEntity = new ItemEntity(request.getTitle(), request.getUsername(), request.getPassword(),
                request.getUrl(), request.getNotes(), holder);
        itemEntity = itemRepository.save(itemEntity);
        return transformEntity(itemEntity);
    }

    public Item update(Long id, ItemManipulationRequest request) {
        var itemEntityOptional = itemRepository.findById(id);
        if (itemEntityOptional.isEmpty()) return null;

        var itemEntity = itemEntityOptional.get();
        itemEntity.setTitle(request.getTitle());
        itemEntity.setUsername(request.getUsername());
        itemEntity.setPassword(request.getPassword());
        itemEntity.setUrl(request.getUrl());
        itemEntity.setNotes(request.getNotes());
        itemEntity = itemRepository.save(itemEntity);

        return transformEntity(itemEntity);
    }

    public boolean deleteById(Long id) {
        if (!itemRepository.existsById(id)) {
            return false;
        }

        itemRepository.deleteById(id);
        return true;
    }

    private Item transformEntity(ItemEntity itemEntity) {
        return new Item(
                itemEntity.getId(),
                itemEntity.getTitle(),
                itemEntity.getUsername(),
                itemEntity.getPassword(),
                itemEntity.getUrl(),
                itemEntity.getNotes(),
                userTransformer.transformEntity(itemEntity.getHolder()));
    }
}
