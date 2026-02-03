package com.manage.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.demo.model.Product;
import com.manage.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductRepository productRepo;

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {	
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer Id) {
		return productRepo.findById(Id).get();
	}

	@Override
	public String deleteProduct(Integer Id) {
		Product product=productRepo.findById(Id).get();
		
		if(product!=null) {
			productRepo.delete(product);
			return "Product Delete Successfully";
		}
		
		return "Something Went Wrong";
	}

	@Override
	public Product editProduct(Product p, Integer Id) {
		Product oldProduct=productRepo.findById(Id).get();
		oldProduct.setProductName(p.getProductName());
		oldProduct.setProductName(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setStatus(p.getStatus());
		return productRepo.save(oldProduct);
	}
	

}
