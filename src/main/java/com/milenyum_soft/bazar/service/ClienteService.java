package com.milenyum_soft.bazar.service;

import com.milenyum_soft.bazar.modelo.Cliente;
import com.milenyum_soft.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;
    @Override
    public void createdClient(Cliente cliente) {
        clienteRepository.save(cliente);

    }

    @Override
    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        return  clienteRepository.findById(id).get();
    }

    @Override
    public void deleteCliente(Long id) {

        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {

        Cliente client = this.getCliente(cliente.getId_cliente());
        client.setId_cliente(cliente.getId_cliente());
        client.setNombre(cliente.getNombre());
        client.setApellido(cliente.getApellido());
        client.setDni(client.getDni());

        this.createdClient(client);
        return client;
    }
}
