package com.project.back_linkpage.controller;

import com.project.back_linkpage.dto.LinkRequestDTO;
import com.project.back_linkpage.dto.LinkResponseDTO;
import com.project.back_linkpage.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/links")
public class LinkController {
    @Autowired
    public LinkService linkservice;

    @PostMapping
    public ResponseEntity<LinkResponseDTO> createLink(@Valid @RequestBody LinkRequestDTO linkRequestDTO) {
        LinkResponseDTO newLink = linkservice.create(linkRequestDTO);
        return ResponseEntity.ok(newLink);
    }

    @GetMapping
    public ResponseEntity<List<LinkResponseDTO>> getAllLinks() {
        return ResponseEntity.ok(linkservice.getAllLinks());
    }

    @PutMapping ResponseEntity<LinkResponseDTO> updateLink(@PathVariable Long id, @RequestBody LinkRequestDTO linkRequestDTO) {
        return ResponseEntity.ok(linkservice.updateLink(id, linkRequestDTO));
    }

    @DeleteMapping ResponseEntity<LinkResponseDTO> deleteLink(@PathVariable Long id) {
        linkservice.deleteLink(id);
        return ResponseEntity.noContent().build();
    }
}