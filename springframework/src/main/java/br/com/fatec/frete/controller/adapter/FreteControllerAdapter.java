package br.com.fatec.frete.controller.adapter;

import java.util.UUID;
import br.com.fatec.frete.controller.dto.request.FreteRequest;
import br.com.fatec.frete.controller.dto.response.FreteResponse;
import br.com.fatec.frete.entity.Frete;

public class FreteControllerAdapter {
    private FreteControllerAdapter() {
    }

    public static FreteResponse cast(Frete frete) {
        return new FreteResponse(
                frete.id(),
                frete.idUser(),
                frete.status(),
                frete.valor()
        );
    }

    public static Frete cast(FreteRequest request) {
        return new Frete(
                UUID.randomUUID().toString(),
                request.idUser(),
                null,
                null
        );
    }
}
