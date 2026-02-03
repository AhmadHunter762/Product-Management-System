package com.manage.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
