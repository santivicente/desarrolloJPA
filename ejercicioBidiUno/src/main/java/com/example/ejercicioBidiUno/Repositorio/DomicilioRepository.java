package com.example.ejercicioBidiUno.Repositorio;

import com.example.ejercicioBidiUno.Entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {

}
