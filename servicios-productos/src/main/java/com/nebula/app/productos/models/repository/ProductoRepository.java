package com.nebula.app.productos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.nebula.app.productos.models.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
