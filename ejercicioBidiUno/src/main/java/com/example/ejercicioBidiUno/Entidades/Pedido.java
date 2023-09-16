package com.example.ejercicioBidiUno.Entidades;

import com.example.ejercicioBidiUno.Enums.EstadoPedido;
import com.example.ejercicioBidiUno.Enums.TipoEnvio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="Pedido") //Se llama igual que la clase
public class Pedido extends BaseEntidad{

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double total;
    private EstadoPedido estado;
    private TipoEnvio tipoEnvio;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="pedido_id")
    @Builder.Default
    private List<DetallePedido> Detallepedidos= new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="factura_id")
    private Factura factura;

    public void agregarDetallePedido(DetallePedido detPed){
        Detallepedidos.add(detPed);
    }
}
