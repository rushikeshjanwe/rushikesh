package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repo.ProductRepo;


@Service
public class ProductServieRepo implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public boolean saveProduct(Product p) {
		// TODO Auto-generated method stub
		Product savedProduct = productRepo.save(p);
		return savedProduct.getPid()!=null;
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		return productRepo.findAll();
	}

}
