package com.matthewradermacher.compuparts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.matthewradermacher.compuparts.dto.ProductCatalog;
import com.matthewradermacher.compuparts.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Override
	public List<Product> findAll();
	
	@Query(nativeQuery=true, value="SELECT p.product_id as product_id, p.name as name, p.description as description, p.price as price, p.quantity as quantity "
			+ "FROM product p "
			+ "WHERE p.product_id=?1")
	public ProductCatalog findById(int id);
	
	@Query(nativeQuery=true, value="UPDATE product "
			+ "SET quantity = quantity - 1 "
			+ "WHERE quantity > 0 AND product_id = ?1")
	public void tryPurchase(int id);
}
