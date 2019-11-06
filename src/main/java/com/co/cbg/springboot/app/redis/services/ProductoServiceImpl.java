package com.co.cbg.springboot.app.redis.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.cbg.springboot.app.redis.dao.IProductoDao;
import com.co.cbg.springboot.app.redis.model.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	IProductoDao productoDao;
	
	@Override
	public void setProductoAsString(String idKey, String producto) {
		productoDao.setProductoAsString(idKey, producto);
	}

	@Override
	public String getProductoAsString(String idKey) {
		return productoDao.getProductoAsString(idKey);
	}

	@Override
	public void AddToProductosList(Producto producto) {
		productoDao.AddToProductosList(producto);
	}

	@Override
	public List<Producto> getProductosListMembers() {
		return productoDao.getProductosListMembers();
	}

	@Override
	public Long getProductosListCount() {
		return productoDao.getProductosListCount();
	}

	@Override
	public void AddToProductosSet(Producto... productos) {
		productoDao.AddToProductosSet(productos);
	}

	@Override
	public Set<Producto> getProductosSetMembers() {
		return productoDao.getProductosSetMembers();
	}

	@Override
	public boolean isSetMember(Producto producto) {
		return productoDao.isSetMember(producto);
	}

	@Override
	public void savePHash(Producto producto) {
		productoDao.saveHash(producto);
	}

	@Override
	public void updatePHash(Producto producto) {
		productoDao.updateHash(producto);
	}

	@Override
	public Map<Integer, Producto> findAllPHash() {
		return productoDao.findAllHash();
	}

	@Override
	public Producto findInPHash(int id) {
		return productoDao.findInHash(id);
	}

	@Override
	public void deletePHash(int id) {
		productoDao.deleteHash(id);
	}

}
