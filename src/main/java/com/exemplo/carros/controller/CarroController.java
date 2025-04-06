package com.exemplo.carros.controller;

import com.exemplo.carros.model.Carro;
import com.exemplo.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    // GET /carros/potencia
    @GetMapping("/potencia")
    public List<Carro> getTop10Potencia() {
        return service.top10PorPotencia();
    }

    // GET /carros/economia
    @GetMapping("/economia")
    public List<Carro> getTop10Economia() {
        return service.top10PorEconomia();
    }

    // GET /carros/eletricos
    @GetMapping("/eletricos")
    public List<Carro> getEletricos() {
        return service.listarEletricos();
    }

    // GET /carros/{id}
    @GetMapping("/{id}")
    public Carro getPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // POST /carros
    @PostMapping
    public Carro criar(@RequestBody Carro carro) {
        return service.salvar(carro);
    }

    // PUT /carros/{id}
    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @RequestBody Carro dados) {
        return service.atualizar(id, dados);
    }

    // DELETE /carros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
