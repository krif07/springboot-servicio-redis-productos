package com.co.cbg.springboot.app.redis.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.co.cbg.springboot.app.redis.model.Producto;

public interface IProductoDao {

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
	void saveHash(Producto producto);

	void updateHash(Producto producto);

	Map<Integer, Producto> findAllHash();

	Producto findInHash(int id);

	void deleteHash(int id);
}
