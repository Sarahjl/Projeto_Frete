package br.com.fatec.frete.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record FreteRequest(
        @NotBlank(message = "O id do usuário não pode ser null")
        String idUser
) {
}
