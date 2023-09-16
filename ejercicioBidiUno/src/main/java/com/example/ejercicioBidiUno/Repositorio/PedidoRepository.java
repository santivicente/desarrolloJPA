package com.example.ejercicioBidiUno.Repositorio;

import com.example.ejercicioBidiUno.Entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
