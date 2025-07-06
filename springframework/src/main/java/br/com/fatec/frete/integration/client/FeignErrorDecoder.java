package br.com.fatec.frete.integration.client;

import br.com.fatec.frete.exception.BadRequestException;
import br.com.fatec.frete.exception.InternalServerException;
import br.com.fatec.frete.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        System.out.println("API STATUS RESPONSE: " + response.status());
        switch (response.status()) {
            case 400:
                throw new BadRequestException("Itens enviados ao frete estao com erros");
            case 404:
                throw new NotFoundException("Usuario nao existe");
            default:
                throw new InternalServerException(s);
        }
    }
}
