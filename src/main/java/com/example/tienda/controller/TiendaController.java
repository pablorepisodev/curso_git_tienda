package com.example.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Producto;
import com.example.tienda.service.IProductoService;

@RestController
public class TiendaController {

	@Autowired
	IProductoService productoService;

	@PostMapping("/guardarProducto")
	public void guardarProducto(@RequestBody Producto producto) {
		productoService.guardaProducto(producto);

	}

	@GetMapping("/listarProductos")
	public List<Producto> listarProductos() {
		return productoService.listarProductos();
	}
	
	@GetMapping("/listarMayoresX/{precio}")
	public List<Producto> listarMayoresX(@PathVariable int precio) {
		return productoService.listarMayoresX(precio);
	}
	
	@GetMapping("/listarProductoEmpiezaX/{valor}")
	public List<Producto> listarProductoEmpiezaX(@PathVariable String valor) {
		return productoService.productoEmpiezaPorX(valor);
	}
	
	@GetMapping("/listarProducto/{id}")
	public Optional<Producto> listarProducto(@PathVariable int id) {
		return productoService.listarProducto(id);
	}
	
	@DeleteMapping("borrarProducto/{id}")
	public void borrarProducto(@PathVariable int id) {
		productoService.borrarProducto(id);
	}

}
