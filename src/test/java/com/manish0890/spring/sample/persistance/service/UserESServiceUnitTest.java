package com.manish0890.spring.sample.persistance.service;

import com.manish0890.spring.sample.model.exceptions.NotFoundException;
import com.manish0890.spring.sample.persistance.document.User;
import com.manish0890.spring.sample.persistance.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static com.manish0890.spring.sample.TestUtility.getSampleUser;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserESServiceUnitTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserESService service;

    @Test
    void testCreateNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> service.create(null));

        assertEquals("User cannot be empty", e.getMessage());
    }

    @Test
    void testCreateIdNotNull() {
        // Create test data
        User testUser = getSampleUser();
        testUser.setId(randomAlphanumeric(5));

        // Exercise test method and perform assertions
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> service.create(testUser));

        assertEquals("Id must be empty while creating entry", e.getMessage());
    }


    @Test
    void testDeleteByIdNotFound() {
        // Create test data
        String id = randomAlphanumeric(5);

        // mock some responses
        when(repository.existsById(eq(id))).thenReturn(false);

        // Alternative ways

        // Following will try to return id in the response but will fail since required return type is boolean
        // when(repository.existsById(eq(id))).then(AdditionalAnswers.returnsFirstArg());

        // Following will let you control the answer and also let you do assertions
//        when(repository.existsById(eq(id))).thenAnswer((Answer<?>) invocation -> {
//            String argumentId = invocation.getArgument(0);
//            assertEquals(id, argumentId);
//            return false;
//        });

        // Exercise test method and perform assertions
        NotFoundException e = assertThrows(NotFoundException.class,
                () -> service.deleteById(id));

        assertEquals("User with ID: " + id + " does not exist", e.getMessage());
    }
}
