package br.com.fatec.frete.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.fatec.frete.integration.dto.UserResponse;

@FeignClient(
        name = "UserIntegration",
        url = "${userpokemon.url}"
)
public interface UserIntegrationWithFeign {
    @GetMapping("/pokemon/v1/user/find-id/{id}")
    UserResponse getUser(@PathVariable(name = "id") String id);
}
