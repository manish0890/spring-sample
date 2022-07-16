package com.manish0890.spring.sample.persistance.repository.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manish0890.spring.sample.persistance.document.User;
import com.manish0890.spring.sample.persistance.repository.UserRepositoryCustom;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.manish0890.spring.sample.constants.ElasticsearchIndices.USERS;
import static com.manish0890.spring.sample.persistance.document.User.FIELD_FIRST_NAME;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final RestHighLevelClient client;
    private final ObjectMapper mapper;

    @Autowired
    public UserRepositoryImpl(RestHighLevelClient client) {
        this.client = client;
        mapper = new ObjectMapper();
    }

    /**
     * Custom way of creating and executing Elasticsearch queries over database
     * Finds all users matching with provided firstName
     * @param firstName
     * @return
     */
    @Override
    public List<User> findByFirst(String firstName) {

        SearchSourceBuilder builder = new SearchSourceBuilder().size(100);

        builder.query(QueryBuilders.termQuery(FIELD_FIRST_NAME, firstName));

        SearchRequest searchRequest = new SearchRequest(USERS);
        searchRequest.source(builder);

        SearchResponse response;
        try {
            response = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<User> users = new ArrayList<>();

        for (SearchHit hit : response.getHits().getHits()) {
            try {
                User user = mapper.readValue(hit.getSourceAsString(), User.class);
                user.setId(hit.getId());
                users.add(user);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return users;

    }
}
