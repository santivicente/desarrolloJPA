package com.example.ejercicioBidiUno.Entidades;

import com.example.ejercicioBidiUno.Enums.FormaPago;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="Factura") //Se llama igual que la clase
public class Factura extends BaseEntidad{

    private int numero;
    private Date fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;
}
