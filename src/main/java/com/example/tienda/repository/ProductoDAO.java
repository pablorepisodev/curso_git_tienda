package com.example.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tienda.model.Producto;

public interface ProductoDAO extends CrudRepository<Producto, Long>{

}
