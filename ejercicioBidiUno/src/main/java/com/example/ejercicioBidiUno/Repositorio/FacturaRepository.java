package com.example.ejercicioBidiUno.Repositorio;

import com.example.ejercicioBidiUno.Entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {

}
