package de.htw.webtech.SafePass.service;

import de.htw.webtech.SafePass.persistence.UserEntity;
import de.htw.webtech.SafePass.persistence.UserRepository;
import de.htw.webtech.SafePass.web.api.User;
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
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getFirstName(),
                        userEntity.getLastName(),
                        userEntity.getCountry(),
                        userEntity.getZipCode()
                ))
                .collect(Collectors.toList());
    }
}
