package com.nebula.app.items.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nebula.app.items.models.Producto;

@FeignClient(name = "product-services")
public interface ProductoClienteRest {

	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/detalle/{id}")
	public Producto detalle(@PathVariable Long id);
	
}
