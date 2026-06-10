package br.com.veloxwrap.repository;

import br.com.veloxwrap.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}