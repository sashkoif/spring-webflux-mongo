package com.sashko.taskmongo;


import java.util.List;

import com.sashko.taskmongo.models.Node;
import com.sashko.taskmongo.repositories.NodeRepository;
import com.sashko.taskmongo.services.NodeService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class NodeRepositoryUnitTest {

    @Mock
    private NodeRepository nodeRepository;

    @Test
    void shouldSaveNodeSuccessfully(){
        final Node node = new Node("1", "test1", "test1");

        given(nodeRepository.save(node)).willAnswer(invocation->invocation.getArgument(0));

        List<Node> savedNodes = nodeRepository.findAll();

        assertThat(savedNodes.size()).isGreaterThanOrEqualTo(1);

    }
}
