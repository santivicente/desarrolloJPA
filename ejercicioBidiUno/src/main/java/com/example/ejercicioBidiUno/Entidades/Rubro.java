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
@Table(name ="Rubro") //Se llama igual que la clase
public class Rubro extends BaseEntidad{

    private String denominacion;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="rubro_id")
    @Builder.Default
    private List<Producto> productos= new ArrayList<>();

    public void agregarProducto(Producto prod){
        productos.add(prod);
    }
}
