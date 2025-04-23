package br.com.fiap.jogo_medieval_api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.jogo_medieval_api.model.Item;
import br.com.fiap.jogo_medieval_api.model.Personagem;

@RestController
@RequestMapping("/item")
public class ItemController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Item> itens = new ArrayList<>();

    public ItemController() {
        Personagem dono1 = new Personagem("Arthas", "guerreiro", 40, 1500.0);
        itens.add(new Item("Espada Flamejante", "arma", "épico", 200.0, dono1));
        itens.add(new Item("Armadura de Gelo", "armadura", "raro", 150.0, dono1));
        itens.add(new Item("Poção de Cura", "poção", "comum", 25.0, dono1));
        itens.add(new Item("Anel da Sorte", "acessório", "lendário", 500.0, dono1));
    }

    // Buscar por nome parcial
    @GetMapping("/nome/{nome}")
    public List<Item> buscarPorNome(@PathVariable String nome) {
        log.info("Buscando item " + nome);
        return getItemPeloNome(nome);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Item> buscarPorTipo(@PathVariable String tipo) {
        log.info("Buscando item pelo tipo " + tipo);
        return getItemPeloTipo(tipo);
    }

    private List<Item> getItemPeloNome(String nome) {
        List<Item> encontrados = itens.stream()
                .filter(i -> i.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());

        if (encontrados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum item encontrado com: " + nome);
        }

        return encontrados;
    }

    private List<Item> getItemPeloTipo(String tipo) {
        List<Item> encontrados = itens.stream()
                .filter(i -> i.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(Collectors.toList());

        if (encontrados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum item encontrado com o tipo: " + tipo);
        }

        return encontrados;
    }
    
}
