package br.com.fatec.frete.repository;

import br.com.fatec.frete.entity.Frete;
import br.com.fatec.frete.exception.InternalServerException;
import br.com.fatec.frete.exception.NotFoundException;
import br.com.fatec.frete.repository.adapter.FreteRepositoryAdapter;
import br.com.fatec.frete.repository.client.FreteRepositoryWithMongo;
import br.com.fatec.frete.repository.orm.FreteOrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class FreteRepositoryImpl implements FreteRepository {
    private static final Logger LOG = LoggerFactory.getLogger(FreteRepositoryImpl.class);
    private final FreteRepositoryWithMongo repository;

    public FreteRepositoryImpl(FreteRepositoryWithMongo repository) {
        this.repository = repository;
    }

    @Override
    public Frete save(Frete frete) {
        try {
            FreteOrm orm = FreteRepositoryAdapter.cast(frete);
            return FreteRepositoryAdapter.cast(repository.save(orm));
        } catch (Exception ex) {
            LOG.error("Erro ao salvar frete: {} o erro aconteceu na data/hora: {}", ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }

    @Override
    public Frete findById(final String id) {
        try {
            Optional<FreteOrm> optional = repository.findById(id);
            if (optional.isEmpty()) {
                throw new NotFoundException("Frete nao existe");
            }
            return FreteRepositoryAdapter.cast(repository.save(optional.get()));
        } catch (NotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            LOG.error("Erro ao procurar frete por id: {} o erro aconteceu na data/hora: {}", ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }

    @Override
    public List<Frete> findByIdUser(final String idUser) {
        try {
            List<FreteOrm> fretesOrm  = repository.findByIdUser(idUser);

            if (fretesOrm.isEmpty()) {
                throw new NotFoundException("Nenhum frete encontrado para o usuário: " + idUser);
            }

            return FreteRepositoryAdapter.cast(fretesOrm);
        } catch (NotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            LOG.error("Erro ao procurar fre por id do usuario: {} o erro aconteceu na data/hora: {}", ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }
}
