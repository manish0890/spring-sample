package com.manish0890.spring.sample.persistance.repository;

import com.manish0890.spring.sample.persistance.document.Player;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ElasticsearchRepository<Player, String> {
    Player findByPlayerID(String playerID);
}
