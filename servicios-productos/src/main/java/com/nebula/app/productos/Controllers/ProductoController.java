package com.nebula.app.productos.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nebula.app.productos.models.entity.Producto;
import com.nebula.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private Environment env;

	@Autowired
	private IProductoService productoService;

	@Value("${server.port}")
	private Integer port;

	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoService.findAll().stream().map(x -> {
			x.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			// x.setPort(port);
			return x;
		}).collect(Collectors.toList());
	}

	@GetMapping("/detalle/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		// producto.setPort(port);

		/*
		 * try { Thread.sleep(2000L); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

		return producto;
	}

}
