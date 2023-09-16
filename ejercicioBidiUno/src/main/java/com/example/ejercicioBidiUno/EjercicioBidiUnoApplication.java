package com.example.ejercicioBidiUno;

import com.example.ejercicioBidiUno.Entidades.*;
import com.example.ejercicioBidiUno.Enums.EstadoPedido;
import com.example.ejercicioBidiUno.Enums.FormaPago;
import com.example.ejercicioBidiUno.Enums.TipoEnvio;
import com.example.ejercicioBidiUno.Enums.TipoProducto;
import com.example.ejercicioBidiUno.Repositorio.ClienteRepository;
import com.example.ejercicioBidiUno.Repositorio.DomicilioRepository;
import com.example.ejercicioBidiUno.Repositorio.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class EjercicioBidiUnoApplication {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    DomicilioRepository domicilioRepository;
    @Autowired
    RubroRepository rubroRepository;

    public static void main(String[] args) {
        SpringApplication.run(EjercicioBidiUnoApplication.class, args);
        System.out.println("Hola si estoy funcionando");

    }

    @Bean
    CommandLineRunner init(ClienteRepository clienteRepo){
        return args -> {
            System.out.println("===========Si, estoy funcionando=============");

            Cliente cliente= new Cliente();
            cliente.setNombre("Juan");
            cliente.setApellido("Rodriguez");
            cliente.setEmail("maricarmen@gmail.com");

            Domicilio domicilio1 = Domicilio.builder()
                    .calle("Estrada")
                    .localidad("Guaymallen")
                    .numero("009")
                    .build();

            Pedido pedido1= Pedido.builder()
                    .total(20000.00)
                    .estado(EstadoPedido.INICIADO)
                    .tipoEnvio(TipoEnvio.DELIVERY)
                    .build();

            Factura factura1=Factura.builder()
                    .total(20302000)
                    .descuento(23.01)
                    .formaPago(FormaPago.EFECTIVO)
                    .build();

            pedido1.setFactura(factura1);
            cliente.agregarPedido(pedido1);
            cliente.agregarDomicilio(domicilio1);

            Producto producto1=Producto.builder()
                    .precioCompra(20.00)
                    .precioVenta(300.00)
                    .denominacion("Dignidad")
                    .tipo(TipoProducto.MANUFACTURADO)
                    .build();

            Producto producto2=Producto.builder()
                    .precioCompra(220.00)
                    .precioVenta(3030.00)
                    .denominacion("Felicidad")
                    .tipo(TipoProducto.MANUFACTURADO)
                    .build();

            Rubro rubro1=Rubro.builder()
                    .denominacion("Articulos de oficina")
                    .build();

            rubro1.agregarProducto(producto1);
            rubro1.agregarProducto(producto2);

            clienteRepo.save(cliente);


            Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);
            if (clienteRecuperado != null){
                System.out.println("Nombre: "+ clienteRecuperado.getNombre());
                System.out.println("Apellido: "+ clienteRecuperado.getApellido());
                System.out.println("Email: "+ clienteRecuperado.getEmail());
            }
        };
    }
}
