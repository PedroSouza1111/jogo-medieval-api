package br.com.fiap.jogo_medieval_api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Item {
    
    @NotBlank(message = "campo obrigatório")
    private String nome;
    @Pattern(
        regexp = "arma|armadura|poção|acessório",
        message = "Tipo inválido. Use: arma, armadura, poção ou acessório"
    )
    private String tipo;
    @Pattern(
        regexp = "comum|raro|épico|lendário",
        message = "Raridade inválida. Use: comum, raro, épico ou lendário"
    )
    private String raridade;
    private Double preco;
    private Personagem dono;

    public Item(@NotBlank(message = "campo obrigatório") String nome,
            @Pattern(regexp = "arma|armadura|poção|acessório", message = "Tipo inválido. Use: arma, armadura, poção ou acessório") String tipo,
            @Pattern(regexp = "comum|raro|épico|lendário", message = "Raridade inválida. Use: comum, raro, épico ou lendário") String raridade,
            Double preco, Personagem dono) {
        this.nome = nome;
        this.tipo = tipo;
        this.raridade = raridade;
        this.preco = preco;
        this.dono = dono;
    }
    
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public String getRaridade() {
        return raridade;
    }
    public Double getPreco() {
        return preco;
    }
    public Personagem getDono() {
        return dono;
    }

    
}
