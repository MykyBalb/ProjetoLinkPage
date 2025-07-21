package com.project.back_linkpage.service;

import com.project.back_linkpage.dto.LinkRequestDTO;
import com.project.back_linkpage.dto.LinkResponseDTO;
import com.project.back_linkpage.model.Link;
import com.project.back_linkpage.model.User;
import com.project.back_linkpage.repository.LinkRepository;
import com.project.back_linkpage.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    public LinkResponseDTO create(LinkRequestDTO linkRequestDTO) {
        User user = userRepository.findById(linkRequestDTO.userId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário com id: " + linkRequestDTO.userId() + " não encontrado."));

        Link newLink = new Link();
        newLink.setTitulo(linkRequestDTO.titulo());
        newLink.setUrl(linkRequestDTO.url());
        newLink.setUser(user);

        Link savedLink = linkRepository.save(newLink);
        return mapToLinkResponseDTO(savedLink);
    }

    public List<LinkResponseDTO> getAllLinks() {
        return linkRepository.findAll()
                .stream()
                .map(this::mapToLinkResponseDTO)
                .collect(Collectors.toList());
    }

    public LinkResponseDTO updateLink(Long id, LinkRequestDTO linkRequestDTO) {
        Link existingLink = linkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Link não encontrado com o id: " + id));

        existingLink.setTitulo(linkRequestDTO.titulo());
        existingLink.setUrl(linkRequestDTO.url());

        Link updatedLink = linkRepository.save(existingLink);
        return mapToLinkResponseDTO(updatedLink);
    }

    public void deleteLink(Long id) {
        if (!linkRepository.existsById(id)) {
            throw new EntityNotFoundException("Link não encontrado com o id: " + id);
        }
        linkRepository.deleteById(id);
    }

    private LinkResponseDTO mapToLinkResponseDTO(Link link) {
        return new LinkResponseDTO(
                link.getId(),
                link.getTitulo(),
                link.getUrl(),
                link.getUser().getUsername() // Retorna apenas o username do dono
        );
    }
}
