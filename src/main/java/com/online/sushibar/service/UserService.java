package com.online.sushibar.service;

import com.online.sushibar.entity.User;
import com.online.sushibar.exception.ResourceNotFoundException;
import com.online.sushibar.exception.UserAlreadyRegisteredException;
import com.online.sushibar.exception.UserNotFoundException;
import com.online.sushibar.form.RegisterForm;
import com.online.sushibar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User register(RegisterForm form) {
        if (userRepository.existsByEmail(form.getEmail())) {
            throw new UserAlreadyRegisteredException();
        }

        User user = User.builder()
                .email(form.getEmail())
                .userName(form.getName())
                .password(passwordEncoder.encode(form.getPassword()))
                .build();
        userRepository.save(user);
        return user;
    }

    public User getByEmail(String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return user;
    }

    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
