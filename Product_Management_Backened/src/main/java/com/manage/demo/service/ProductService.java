package com.manage.demo.service;

import java.util.List;

import com.manage.demo.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
		
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer Id);
	
	public String deleteProduct(Integer Id);
	
	public Product editProduct(Product product,Integer Id);
}
