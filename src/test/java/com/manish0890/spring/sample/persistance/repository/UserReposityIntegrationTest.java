package com.manish0890.spring.sample.persistance.repository;

import com.manish0890.spring.sample.TestDataCleanup;
import com.manish0890.spring.sample.persistance.document.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static com.manish0890.spring.sample.TestUtility.getSampleUser;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserReposityIntegrationTest extends TestDataCleanup {

    @Autowired
    private UserRepository repository;

    @Test
    void testCreate() {
        // Create test data
        User expectedUser = getSampleUser();

        // Exercise the method
        User actualUser = repository.save(expectedUser);

        // Assertions
        assertNotNull(actualUser);
        assertNotNull(actualUser.getId());
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testFindById() {
        // Create test data
        User expectedUser = getSampleUser();
        repository.save(expectedUser);

        // Exercise method
        User actualUser = repository.findById(expectedUser.getId()).get();

        // Assertions
        assertNotNull(actualUser);
        assertNotNull(actualUser.getId());
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testFindAllByLastName() {
        // Create test data
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = getSampleUser();
            user.setLastName("asd");
            repository.save(user);
            users.add(user);
        }

        // Exercise the method
        List<User> actualUsers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Page<User> page = repository.findAllByLastNameOrderByCreatedDateAsc("asd", PageRequest.of(i, 5));
            assertEquals(page.getSize(), 5);
            page.get().forEach(actualUser -> assertTrue(users.contains(actualUser)));
            actualUsers.addAll(page.getContent());
        }

        // Assertions
        assertEquals(users, actualUsers);
    }
}
