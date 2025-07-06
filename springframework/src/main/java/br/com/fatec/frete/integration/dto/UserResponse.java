package br.com.fatec.frete.integration.dto;

import br.com.fatec.frete.entity.Endereco;

public record UserResponse(
        String id,
        String nome,
        String email,
        Endereco endereco
) {
}