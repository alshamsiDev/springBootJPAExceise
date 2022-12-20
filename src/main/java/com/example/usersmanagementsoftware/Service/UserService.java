package com.example.usersmanagementsoftware.Service;

import com.example.usersmanagementsoftware.Model.User;
import com.example.usersmanagementsoftware.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> all() {
        return userRepository.findAll();
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public Boolean update(Integer id, User user) {
        User currentUser = userRepository.getReferenceById(id);
        System.out.println(currentUser);
        if (currentUser == null) {
            return false;
        }
        currentUser.setName(user.getName());
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());
        currentUser.setAge(user.getAge());
        currentUser.setRole(user.getRole());
        userRepository.save(currentUser);
        return true;
    }

    public void delete(Integer id) {
        User user = userRepository.getReferenceById(id);
        if (!(user instanceof User)){
            return;
        }
        userRepository.delete(user);
    }
}
