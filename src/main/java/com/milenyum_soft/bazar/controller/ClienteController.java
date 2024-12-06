package com.milenyum_soft.bazar.controller;

import com.milenyum_soft.bazar.modelo.Cliente;
import com.milenyum_soft.bazar.service.ClienteService;
import com.milenyum_soft.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService  clienteService;


    @PostMapping("clientes/crear")
    public String created(@RequestBody Cliente cliente) {
        clienteService.createdClient( cliente );

        return "Cliente creado exitosamente";

    }

    @GetMapping("clientes")
    public List<Cliente> listClientes() {

        return clienteService.listClientes();
    }

    @GetMapping( "clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente) {
        return clienteService.getCliente( id_cliente );
    }

    @DeleteMapping( "clientes/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {

        clienteService.deleteCliente( id_cliente );
        return "Cliente eliminado exitosamente";
    }

    @PutMapping("clientes/editar/{id_cliente}")
    public String editCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente) {

        Cliente client1 = clienteService.getCliente( id_cliente);
        String nombrecl= client1.getNombre();
        String apellido= client1.getApellido();
        String dni= client1.getDni();
        System.out.println(client1.toString());

        Cliente client2 = clienteService.updateCliente(cliente);
        System.out.println(client2.toString());
        System.out.println("Buenas noches donde estás;");

        return "Cliente editado exitosamente "  + "Cliente antiguo: " + nombrecl + " Cliente editado:  " + client2.toString();

    }

}
