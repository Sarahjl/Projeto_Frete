package br.com.fatec.frete.entity;

public record User(
        String id,
        String nome,
        String email,
        Endereco endereco
) {
}