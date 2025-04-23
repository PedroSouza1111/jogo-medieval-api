package br.com.fiap.jogo_medieval_api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.jogo_medieval_api.model.Personagem;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Personagem> repository = new ArrayList<>();

}
