package cz.skolaprojekt.sborovnatodo.service;

import cz.skolaprojekt.sborovnatodo.model.User;
import cz.skolaprojekt.sborovnatodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }
}
