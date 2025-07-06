package br.com.fatec.frete.integration.adapter;

import br.com.fatec.frete.entity.User;
import br.com.fatec.frete.integration.dto.UserResponse;

public class UserIntegrationAdapter {
        private UserIntegrationAdapter() {
        }

        public static User cast(UserResponse response) {
                return new User(
                        response.id(),
                        response.nome(),
                        response.email(),
                        response.endereco()
                );
        }
}
