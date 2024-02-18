package ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain.User;
import ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
