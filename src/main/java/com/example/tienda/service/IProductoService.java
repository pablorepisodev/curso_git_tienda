package com.example.tienda.service;

import java.util.List;
import java.util.Optional;

import com.example.tienda.model.Producto;

public interface IProductoService {
	public void guardaProducto(Producto producto);
	
	public List<Producto> listarProductos();
	
	public Optional<Producto> listarProducto(int id);
	
	public void borrarProducto (int id);
	
	public List<Producto> listarMayoresX(int valor);
	
	public List<Producto> productoEmpiezaPorX(String valor);
}
