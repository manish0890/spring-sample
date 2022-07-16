package com.manish0890.spring.sample.persistance.repository;

import com.manish0890.spring.sample.persistance.document.User;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> findByFirst(String firstName);
}
