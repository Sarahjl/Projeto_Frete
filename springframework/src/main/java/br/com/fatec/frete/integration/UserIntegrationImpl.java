package br.com.fatec.frete.integration;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import br.com.fatec.frete.entity.User;
import br.com.fatec.frete.integration.adapter.UserIntegrationAdapter;
import br.com.fatec.frete.integration.client.UserIntegrationWithFeign;
import br.com.fatec.frete.integration.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserIntegrationImpl implements UserIntegration {
        private UserIntegrationWithFeign integration;

        public UserIntegrationImpl(UserIntegrationWithFeign integration) {
                this.integration = integration;
        }

        @Retryable(maxAttempts = 4, backoff = @Backoff(delay = 1000))
        @Cacheable(value = "user-cache", key = "#p0")
        public User getUser(final String idUser) {
                UserResponse response = integration.getUser(idUser);
                return UserIntegrationAdapter.cast(response);
        }
}
