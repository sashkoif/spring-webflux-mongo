package com.sashko.taskmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import com.sashko.taskmongo.models.DTO.NodeDTO;
import com.sashko.taskmongo.models.Node;
import com.sashko.taskmongo.repositories.NodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {
    NodeRepository nodeRepository;
    
	public NodeService(@Autowired NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }
    
    public List<NodeDTO> getAllNodes(){
        return nodeRepository.findAll().stream().map(this::convertNodeToNodeDTO).collect(Collectors.toList());
    }
    
    public NodeDTO saveUpdateNode(NodeDTO node){
        return convertNodeToNodeDTO(nodeRepository.save(convertNodeDTOToNode(node)));
    }

    private NodeDTO convertNodeToNodeDTO(Node node) {
        return new NodeDTO(node.getId(),node.getName(),node.getDescription());
    }

    private Node convertNodeDTOToNode(NodeDTO nodeDTO) {
        return new Node(nodeDTO.getId(),nodeDTO.getName(),nodeDTO.getDescription());
    }
}
