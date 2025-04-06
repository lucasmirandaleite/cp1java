package com.exemplo.carros.repository;


import com.exemplo.carros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository



public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findTop10ByOrderByPotenciaDesc();
    List<Carro> findTop10ByOrderByEconomiaDesc();
    List<Carro> findByTipoIgnoreCase(String tipo);
}
