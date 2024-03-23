package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {

	public boolean saveProduct(Product p);
	
	public List<Product> getAllProducts();
}
