package br.com.fatec.frete.controller.dto.response;

import br.com.fatec.frete.entity.StatusFrete;

public record FreteResponse(
        String id,
        String user,
        StatusFrete status,
        String valor
) {
}
