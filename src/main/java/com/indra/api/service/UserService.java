package com.indra.api.service;

import com.indra.api.model.User;
import com.indra.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User update(Long id, User newUser) {
        return repository.findById(id).map(user -> {
            user.setNome(newUser.getNome());
            user.setEmail(newUser.getEmail());
            return repository.save(user);
        }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}