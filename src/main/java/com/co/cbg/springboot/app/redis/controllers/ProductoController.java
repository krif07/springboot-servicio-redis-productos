package com.co.cbg.springboot.app.redis.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.co.cbg.springboot.app.redis.model.Producto;
import com.co.cbg.springboot.app.redis.services.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	IProductoService productoService;
	
	// *******************String Demo*******************//
	
	@RequestMapping(method = RequestMethod.POST, value = "/producto-string")
	public void addProducto(@RequestBody Producto producto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		productoService.setProductoAsString(String.valueOf(producto.getId()),
				mapper.writeValueAsString(producto));

	}

	@RequestMapping("/producto-string/{id}")
	public String readString(@PathVariable String id) {
		return productoService.getProductoAsString(id);

	}

	// *******************LIST Demo*******************//

	// add producto to list
	@RequestMapping(method = RequestMethod.POST, value = "/productos-list")
	public void addToProductoList(@RequestBody Producto producto) {
		productoService.AddToProductosList(producto);

	}

	// get all productos from a list
	@RequestMapping("/productos-list")
	public List<Producto> getProductoListMembers() {
		return productoService.getProductosListMembers();

	}

	// count all productos in a list
	@RequestMapping("/productos-list/count")
	public Long getProductoListCount() {
		return productoService.getProductosListCount();

	}

	// *******************SET Demo*******************//

	// add productos to set
	@RequestMapping(method = RequestMethod.POST, value = "/productos-set")
	public void AddToproductostSet(@RequestBody Producto... productos) {
		productoService.AddToProductosSet(productos);

	}

	// get all productos from a set
	@RequestMapping(method = RequestMethod.GET, value = "/productos-set")
	public Set<Producto> getproductosSetMembers() {
		return productoService.getProductosSetMembers();

	}

	// Check if producto already exists in the set
	@RequestMapping(method = RequestMethod.POST, value = "/productos-set/member")
	public boolean isSetMember(@RequestBody Producto producto) {
		return productoService.isSetMember(producto);

	}

	// *****************HASH Demo**********************//

	// add producto to hash
	@RequestMapping(method = RequestMethod.POST, value = "/productos-hash")
	public void savePHash(@RequestBody Producto producto) {
		productoService.savePHash(producto);

	}

	// update producto in hash
	@RequestMapping(method = RequestMethod.PUT, value = "/productos-hash")
	public void updatePHash(@RequestBody Producto producto) {
		productoService.updatePHash(producto);

	}

	// get all productos from hash
	@RequestMapping(method = RequestMethod.GET, value = "/productos-hash")
	public Map<Integer, Producto> FindAllPHash() {
		return productoService.findAllPHash();

	}

	// get producto from hash
	@RequestMapping(method = RequestMethod.GET, value = "/productos-hash/{id}")
	public Producto FindPInHash(@PathVariable int id) {
		return productoService.findInPHash(id);

	}

	// delete producto from hash
	@RequestMapping(method = RequestMethod.DELETE, value = "/productos-hash/{id}")
	public void deletePhash(@PathVariable int id) {
		productoService.deletePHash(id);

	}

}
