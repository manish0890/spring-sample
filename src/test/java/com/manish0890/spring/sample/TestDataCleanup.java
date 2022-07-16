package com.manish0890.spring.sample;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class TestDataCleanup {

    @Autowired
    List<ElasticsearchRepository> repositories;

    @BeforeEach
    public void deleteAll() {
        repositories.forEach(CrudRepository::deleteAll);
    }
}
