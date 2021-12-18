package de.htw.webtech.SafePass.service;

import de.htw.webtech.SafePass.persistence.ItemEntity;
import de.htw.webtech.SafePass.persistence.UserEntity;
import de.htw.webtech.SafePass.persistence.UserRole;
import de.htw.webtech.SafePass.web.api.User;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserTransformer {
    public User transformEntity(UserEntity userEntity) {
        var userRole = userEntity.getUserRole() != null ? userEntity.getUserRole().name() : null;
        var itemsIds = userEntity.getItemList().stream().map(ItemEntity::getId).collect(Collectors.toList());
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userRole,
                itemsIds);
    }
}
