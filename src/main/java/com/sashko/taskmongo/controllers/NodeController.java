package com.sashko.taskmongo.controllers;

import java.util.List;

import javax.validation.Valid;

import com.sashko.taskmongo.models.DTO.NodeDTO;
import com.sashko.taskmongo.services.NodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/node")
public class NodeController {
    NodeService nodeService;

    public NodeController(@Autowired NodeService nodeService) {
        this.nodeService = nodeService;       
	}

    @GetMapping
    public Mono<List<NodeDTO>> get(){
        return Mono.just(nodeService.getAllNodes());
    }	

    @PostMapping
    public Mono<NodeDTO> updateNode(@Validated @RequestBody NodeDTO nodeDTO){
        return Mono.just(nodeService.saveUpdateNode(nodeDTO));
    }
}