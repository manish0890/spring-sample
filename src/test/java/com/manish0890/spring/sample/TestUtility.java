package com.manish0890.spring.sample;

import com.manish0890.spring.sample.persistance.document.User;

import java.util.Date;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class TestUtility {

    private TestUtility(){}

    public static User getSampleUser() {
        User user = new User();
        user.setFirstName(randomAlphabetic(10));
        user.setLastName(randomAlphabetic(10));
        user.setCity(randomAlphabetic(10));
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        return user;
    }
}
