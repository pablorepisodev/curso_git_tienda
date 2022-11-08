package com.example.tienda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.model.Producto;
import com.example.tienda.repository.ProductoDAO;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ProductoDAO dao;

	@Override
	public void guardaProducto(Producto producto) {
		dao.save(producto);

	}

	@Override
	public List<Producto> listarProductos() {
		return (List<Producto>) dao.findAll();
	}

	@Override
	public Optional<Producto> listarProducto(int id) {
		return dao.findById(Long.valueOf(id));
	}

	@Override
	public void borrarProducto(int id) {
		dao.deleteById(Long.valueOf(id));

	}

	// metodo para mostrar los productos que superen el precio recibido por
	// parametro
	// lambdas y streams with filter
	@Override
	public List<Producto> listarMayoresX(int valor) {
		 List<Producto> listaModificada = (List<Producto>) dao.findAll();
		listaModificada = listaModificada.stream().filter(producto -> producto.getPrecio() > valor)
				.collect(Collectors.toList());
		return listaModificada;
	}

	@Override
	public List<Producto> productoEmpiezaPorX(String valor) {
		List<Producto> listaModificada = (List<Producto>) dao.findAll();
		listaModificada = listaModificada.stream().filter(producto -> producto.getNombreProducto().startsWith(valor))
				.collect(Collectors.toList());

		return listaModificada;
	}

}
