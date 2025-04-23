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
    private List<Personagem> personagens = new ArrayList<>();
    
    public PersonagemController() {
        personagens.add(new Personagem("Pedro", "guerreiro", 40, 1500.0));
        personagens.add(new Personagem("Vinicius", "mago", 60, 3000.0));
        personagens.add(new Personagem("Felipe", "arqueiro", 55, 2000.0));
    }

    // Buscar por nome
    @GetMapping("/nome/{nome}")
    public Personagem buscarPorNome(@PathVariable String nome) {
        log.info("Buscando personagem " + nome);
        return getPersonagem(nome);
    }

    // Buscar por classe
    @GetMapping("/classe/{classe}")
    public Personagem buscarPorClasse(@PathVariable String classe) {
        log.info("Buscando personagens pela classe " + classe);
        return getClasse(classe);
    }

    private Personagem getPersonagem(String nome) {
        return personagens.stream()
                .filter(c -> c.getNome().equals(nome))
                .findFirst()
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem " + nome + " não encontrado")
                );
    }

    private Personagem getClasse(String classe) {
        return personagens.stream()
                .filter(c -> c.getClasse().equals(classe))
                .findFirst()
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum personagem com classe " + classe + " foi encontrado")
                );
    }
}
