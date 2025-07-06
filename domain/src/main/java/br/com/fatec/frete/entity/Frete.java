package br.com.fatec.frete.entity;

public record Frete(
        String id,
        String idUser,
        StatusFrete status,
        String valor
) {
}
