package com.manish0890.spring.sample.persistance.service;

import com.manish0890.spring.sample.model.exceptions.NotFoundException;
import com.manish0890.spring.sample.persistance.document.User;
import com.manish0890.spring.sample.persistance.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Optional;

@Service
public class UserESService {

    private final UserRepository repository;

    @Autowired
    public UserESService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        Assert.notNull(user, "User cannot be empty");
        Assert.isTrue(StringUtils.isBlank(user.getId()), "Id must be empty while creating entry");
        Assert.isTrue(StringUtils.isAlpha(user.getFirstName()), "First name must only be alphabetical");
        Assert.isTrue(StringUtils.isAlpha(user.getLastName()), "Last name must only be alphabetical");

        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        return repository.save(user);
    }

    public User findById(String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "Id cannot be blank ");

        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NotFoundException("User with ID: " + id + " does not exist");
        }
    }

    public User findByFirstName(String firstName) {
        Assert.isTrue(StringUtils.isNotBlank(firstName), "firstName cannot be blank ");

        User user = repository.findByFirstName(firstName);

        if (user != null) {
            return user;
        } else {
            throw new NotFoundException("User with firstName: " + firstName + " does not exist");
        }
    }

    public void deleteById(String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "Id cannot be blank ");

        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("User with ID: " + id + " does not exist");
        }
    }
}
