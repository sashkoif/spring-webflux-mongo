package com.sashko.taskmongo.repositories;

import com.sashko.taskmongo.models.Node;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends MongoRepository<Node, String> {
    
}
