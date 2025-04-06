package com.exemplo.carros.service;


import com.exemplo.carros.model.Carro;
import com.exemplo.carros.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<Carro> top10PorPotencia() {
        return repository.findTop10ByOrderByPotenciaDesc();
    }

    public List<Carro> top10PorEconomia() {
        return repository.findTop10ByOrderByEconomiaDesc();
    }

    public List<Carro> listarEletricos() {
        return repository.findByTipoIgnoreCase("eletrico");
    }

    public Carro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }

    public Carro salvar(Carro carro) {
        return repository.save(carro);
    }

    public Carro atualizar(Long id, Carro dados) {
        Carro carro = buscarPorId(id);
        BeanUtils.copyProperties(dados, carro, "id");
        return repository.save(carro);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
