package com.milenyum_soft.bazar.service;

import com.milenyum_soft.bazar.modelo.Cliente;

import java.util.List;

public interface IClienteService {


    //CREAR
    public void createdClient(Cliente cliente);

    //TRAER LISTA
    public List<Cliente> listClientes();

    //TRAER CLIENTE
    public Cliente getCliente(Long id);

    //ELIMINAR CLIENTE
    public void deleteCliente(Long id);

    //EDITAR CLIENTE

    public Cliente updateCliente(Cliente cliente);


}
