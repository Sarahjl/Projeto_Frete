package br.com.fatec.frete.repository.orm;

import br.com.fatec.frete.entity.StatusFrete;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "frete")
public record FreteOrm(
        @Id
        String id,
        @Indexed
        String idUser,
        StatusFrete status,
        String valor
) {
}
