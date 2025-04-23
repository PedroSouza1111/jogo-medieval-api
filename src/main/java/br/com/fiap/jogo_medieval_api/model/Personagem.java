package br.com.fiap.jogo_medieval_api.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Personagem {

    @NotBlank(message = "campo obrigatório")
    private String nome;
    @Pattern(regexp = "guerreiro|mago|arqueiro", message = "Tipo inválido. Use: guerreiro, mago ou arqueiro")
    private String classe;
    @Min(value = 1, message = "O nível mínimo é 1")
    @Max(value = 99, message = "O nível máximo é 99")
    private int nivel;
    private Double moedas;

    public String getNome() {
        return nome;
    }
    public String getClasse() {
        return classe;
    }
    public int getNivel() {
        return nivel;
    }
    public Double getMoedas() {
        return moedas;
    }

    
}
