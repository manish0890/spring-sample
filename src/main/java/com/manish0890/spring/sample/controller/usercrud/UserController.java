package com.manish0890.spring.sample.controller.usercrud;

import com.manish0890.spring.sample.persistance.document.User;
import com.manish0890.spring.sample.persistance.service.UserESService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.manish0890.spring.sample.constants.RequestMappingConstants.User.USER;
import static com.manish0890.spring.sample.constants.RequestMappingConstants.User.USER_BY_ID;

@RestController
@RequestMapping(USER)
@Tag(name = "User Create Read Update Delete Controller")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserESService userESService;

    @Autowired
    public UserController(UserESService userESService) {
        this.userESService = userESService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Create User")
    public User create(@RequestBody User user) {
        User createdUser = userESService.create(user);
        LOGGER.info("Created user with Id: {}", createdUser.getId());
        return createdUser;
    }

    @GetMapping(value = USER_BY_ID)
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Find User by ID")
    public User findById(@PathVariable String id) {
        User user = userESService.findById(id);
        LOGGER.info("Created user with Id: {}", user.getId());
        return user;
    }
}
