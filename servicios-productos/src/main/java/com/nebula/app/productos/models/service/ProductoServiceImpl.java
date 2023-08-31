package com.nebula.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nebula.app.productos.models.entity.Producto;
import com.nebula.app.productos.models.repository.ProductoRepository;


@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private ProductoRepository repo;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return repo.findById(id).orElse(null);
	}

}
