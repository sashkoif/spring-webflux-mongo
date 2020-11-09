package com.sashko.taskmongo;


import com.sashko.taskmongo.models.Node;
import com.sashko.taskmongo.repositories.NodeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;


@DataMongoTest(includeFilters = @Filter(Component.class))
public class NodeRepositoryUnitTest {

    @Autowired
    NodeRepository nodeRepository;

    @Test
    void shouldSaveNodeSuccessfully(){
        Node node = new Node("1", "test1", "test1");
        Node returnedNode = nodeRepository.save(node);
        assertThat(returnedNode).isNotNull();
    }
}
