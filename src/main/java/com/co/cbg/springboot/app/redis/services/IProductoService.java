package com.co.cbg.springboot.app.redis.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.co.cbg.springboot.app.redis.model.Producto;

public interface IProductoService {

	// String
	void setProductoAsString(String idKey, String producto);

	String getProductoAsString(String idKey);

	// list
	void AddToProductosList(Producto producto);

	List<Producto> getProductosListMembers();

	Long getProductosListCount();

	// Set
	void AddToProductosSet(Producto... productos);

	Set<Producto> getProductosSetMembers();

	boolean isSetMember(Producto producto);

	// Hash
	void savePHash(Producto producto);

	void updatePHash(Producto producto);

	Map<Integer, Producto> findAllPHash();

	Producto findInPHash(int id);

	void deletePHash(int id);

}
