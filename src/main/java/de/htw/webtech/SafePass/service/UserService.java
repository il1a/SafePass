package de.htw.webtech.SafePass.service;

import de.htw.webtech.SafePass.persistence.UserEntity;
import de.htw.webtech.SafePass.persistence.UserRepository;
import de.htw.webtech.SafePass.web.api.User;
import de.htw.webtech.SafePass.web.api.UserManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public User create(UserManipulationRequest request) {
        var userEntity = new UserEntity(request.getFirstName(), request.getLastName(), request.getCountry(), request.getZipCode());
        userEntity = userRepository.save(userEntity);

        return transformEntity(userEntity);
    }

    private User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getCountry(),
                userEntity.getZipCode()
        );
    }
}
