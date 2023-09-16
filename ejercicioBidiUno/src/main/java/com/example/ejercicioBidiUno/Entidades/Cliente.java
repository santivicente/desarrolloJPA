package com.example.ejercicioBidiUno.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="Cliente") //Se llama igual que la clase
public class Cliente extends BaseEntidad{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios= new ArrayList<>();

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="pedido_id")
    @Builder.Default
    private List<Pedido> pedidos= new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){
        domicilios.add(domi);
    }

    public void agregarPedido(Pedido ped){
        pedidos.add(ped);
    }
}
