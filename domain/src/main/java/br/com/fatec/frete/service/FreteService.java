package br.com.fatec.frete.service;

import br.com.fatec.frete.entity.Frete;
import br.com.fatec.frete.entity.StatusFrete;
import br.com.fatec.frete.entity.User;
import br.com.fatec.frete.exception.BadRequestException;
import br.com.fatec.frete.exception.InternalServerException;
import br.com.fatec.frete.exception.NotFoundException;
import br.com.fatec.frete.integration.UserIntegration;
import br.com.fatec.frete.repository.FreteRepository;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FreteService {
    private static final Logger LOG = LoggerFactory.getLogger(FreteService.class);

    private final FreteRepository repository;
    private final UserIntegration integration;

    public FreteService(FreteRepository repository, UserIntegration integration ){
        this.repository = repository;
        this.integration = integration;
    }

    public Frete register(Frete frete){
        try {
            Frete updatedFrete = repository.findById(frete.id());
            return save(updatedFrete.id(), updatedFrete);
        } catch (NotFoundException e) {
            return save(frete);
        }
    }

    public Frete save(Frete frete){
        return this.save(frete.id(), frete);
    }

    private Frete save(final String id, Frete frete) {
        try {
            User user = integration.getUser(frete.idUser());

            if(user.endereco() == null || user.endereco().uf().isBlank()){
                throw new BadRequestException("O usuário não tem estado cadastrado");
            }

            String valorFrete = FreteCalculator.calcularValorFrete(user.endereco().uf());
            Frete newFrete = new Frete(id, frete.idUser(), StatusFrete.PROCESSANDO, valorFrete);

            return repository.save(newFrete);
        } catch (NotFoundException ex) {
            throw new BadRequestException(ex);
        } catch (Exception ex) {
            LOG.error("Erro na regra de negocio ao salvar: {} na data/hora: {}",  ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }
}
