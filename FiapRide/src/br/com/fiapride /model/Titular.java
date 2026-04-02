package br.com.fiapride.model;

public class Titular {
    
    private String nome;
    private String cpf;

    // Construtor obrigatório com atributos essenciais
    public Titular(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}
