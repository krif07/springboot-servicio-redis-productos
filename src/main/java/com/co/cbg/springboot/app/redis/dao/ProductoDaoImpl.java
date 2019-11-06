package com.co.cbg.springboot.app.redis.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import com.co.cbg.springboot.app.redis.model.Producto;

@Repository
public class ProductoDaoImpl implements IProductoDao{

	public static final String REDIS_LIST_KEY = "ProductoList";
	public static final String REDIS_SET_KEY  = "ProductoSET";
	public static final String REDIS_HASH_KEY = "ProductoHash";
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	@Qualifier("listOperations")
	private ListOperations<String, Producto> ListOps;
	
	@Autowired
	@Qualifier("setOperations")
	 private SetOperations<String, Producto> setOps;	
	
	@Autowired
	HashOperations<String, Integer, Producto> hashOps;
	
	@Override
	public void setProductoAsString(String idKey, String producto) {
		redisTemplate.opsForValue().set(idKey, producto);
		redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);		
	}

	@Override
	public String getProductoAsString(String idKey) {
		return (String) redisTemplate.opsForValue().get(idKey);
	}

	@Override
	public void AddToProductosList(Producto producto) {
		ListOps.leftPush(REDIS_LIST_KEY, producto);		
	}

	@Override
	public List<Producto> getProductosListMembers() {
		return ListOps.range(REDIS_LIST_KEY, 0, -1);
	}

	@Override
	public Long getProductosListCount() {
		return ListOps.size(REDIS_LIST_KEY);
	}

	@Override
	public void AddToProductosSet(Producto... productos) {
		setOps.add(REDIS_SET_KEY, productos);
	}

	@Override
	public Set<Producto> getProductosSetMembers() {
		return setOps.members(REDIS_SET_KEY);
	}

	@Override
	public boolean isSetMember(Producto producto) {
		return setOps.isMember(REDIS_SET_KEY,producto);
	}

	@Override
	public void saveHash(Producto producto) {
		hashOps.put(REDIS_HASH_KEY, producto.getId(), producto);
	}

	@Override
	public void updateHash(Producto producto) {
		hashOps.put(REDIS_HASH_KEY, producto.getId(), producto);
	}

	@Override
	public Map<Integer, Producto> findAllHash() {
		return hashOps.entries(REDIS_HASH_KEY);
	}

	@Override
	public Producto findInHash(int id) {
		return hashOps.get(REDIS_HASH_KEY, id);
	}

	@Override
	public void deleteHash(int id) {
		hashOps.delete(REDIS_HASH_KEY, id);
	}

}
