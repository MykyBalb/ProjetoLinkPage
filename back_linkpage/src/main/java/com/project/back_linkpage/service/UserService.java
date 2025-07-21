package com.project.back_linkpage.service;

import com.project.back_linkpage.dto.UserReponseDTO;
import com.project.back_linkpage.dto.UserRequestDTO;
import com.project.back_linkpage.model.User;
import com.project.back_linkpage.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserReponseDTO create(UserRequestDTO userData) {
        User newUser = new User();
        newUser.setName(userData.name());
        newUser.setUsername(userData.username());
        newUser.setEmail(userData.email());

        String hashedPassword = passwordEncoder.encode(userData.password());
        newUser.setHashPassword(hashedPassword);

        User savedUser = userRepository.save(newUser);
        return new UserReponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getUsername());
    }

    public List<UserReponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserReponseDTO(user.getId(), user.getName(), user.getEmail(), user.getUsername()))
                .collect(Collectors.toList());
    }

    public UserReponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o id: " + id));

        existingUser.setName(userRequestDTO.name());
        existingUser.setUsername(userRequestDTO.username());
        existingUser.setEmail(userRequestDTO.email());

        if (userRequestDTO.password() != null && !userRequestDTO.password().isEmpty()) {
            existingUser.setHashPassword(passwordEncoder.encode(userRequestDTO.password()));
        }

        User updatedUser = userRepository.save(existingUser);
        return new UserReponseDTO(updatedUser.getId(), updatedUser.getName(), updatedUser.getEmail(), updatedUser.getUsername());
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com o id: " + id);
        }
        userRepository.deleteById(id);
    }
}
