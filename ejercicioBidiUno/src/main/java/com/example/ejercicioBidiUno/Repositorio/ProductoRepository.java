package com.example.ejercicioBidiUno.Repositorio;

import com.example.ejercicioBidiUno.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

}
