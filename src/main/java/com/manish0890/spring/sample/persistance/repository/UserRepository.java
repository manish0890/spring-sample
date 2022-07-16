package com.manish0890.spring.sample.persistance.repository;

import com.manish0890.spring.sample.persistance.document.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String>, UserRepositoryCustom{
    /**
     * Finds User by First Name
     */
    User findByFirstName(String firstName);

    /**
     * Finds all Users by Last Name
     */
    Page<User> findAllByLastNameOrderByCreatedDateAsc(String lastName, PageRequest pageReq);
}
