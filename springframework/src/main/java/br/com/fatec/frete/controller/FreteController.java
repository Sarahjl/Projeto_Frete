package br.com.fatec.frete.controller;

import br.com.fatec.frete.controller.adapter.FreteControllerAdapter;
import br.com.fatec.frete.controller.dto.request.FreteRequest;
import br.com.fatec.frete.controller.dto.response.FreteResponse;
import br.com.fatec.frete.entity.Frete;
import br.com.fatec.frete.repository.FreteRepository;
import br.com.fatec.frete.service.FreteService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/frete")
public class FreteController {
    private final FreteRepository repository;
    private final FreteService service;

    public FreteController(FreteRepository repository, FreteService service){
        this.repository = repository;
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public FreteResponse find(@PathVariable("id") String id) {
        return FreteControllerAdapter.cast(repository.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public FreteResponse save(@Validated @RequestBody FreteRequest request) {
        Frete frete = FreteControllerAdapter.cast(request);
        return FreteControllerAdapter.cast(service.register(frete));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/by-iduser/{idUser}")
    public List<Frete> findByIdUser(@PathVariable("idUser") String idUser) {
        return repository.findByIdUser(idUser);
    }
}
