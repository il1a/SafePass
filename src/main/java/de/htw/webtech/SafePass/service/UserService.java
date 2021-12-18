package de.htw.webtech.SafePass.service;

import de.htw.webtech.SafePass.persistence.UserEntity;
import de.htw.webtech.SafePass.persistence.UserRepository;
import de.htw.webtech.SafePass.persistence.UserRole;
import de.htw.webtech.SafePass.web.api.User;
import de.htw.webtech.SafePass.web.api.UserManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserTransformer userTransformer;

    public UserService(UserRepository userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(userTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public User findById(Long id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(userTransformer::transformEntity).orElse(null);
    }

    public User create(UserManipulationRequest request) {
        var userRole = UserRole.valueOf(request.getUserRole());
        var userEntity = new UserEntity(request.getEmail(), request.getUsername(), request.getPassword(), userRole);
        userEntity = userRepository.save(userEntity);
        return userTransformer.transformEntity(userEntity);
    }

    public User update(Long id, UserManipulationRequest request) {
        var userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isEmpty()) {
            return null;
        }

        var userEntity = userEntityOptional.get();
        userEntity.setEmail(request.getEmail());
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setUserRole(UserRole.valueOf(request.getUserRole()));
        userEntity = userRepository.save(userEntity);

        return userTransformer.transformEntity(userEntity);
    }

    public boolean deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }
}
