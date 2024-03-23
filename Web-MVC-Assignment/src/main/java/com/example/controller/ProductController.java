package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Product;
import com.example.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/")
	public ModelAndView loadForm() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("pobj", new Product());
		mv.setViewName("index");
		
		return mv;
	}
	
	@PostMapping("/product")
	public ModelAndView saveProduct(Product pobj) {
		ModelAndView mv = new ModelAndView();
		
		boolean status = productService.saveProduct(pobj);
		
		
		if(status) {
			mv.addObject("smsg","Product Saved");
		}
		else {
			mv.addObject("fmsg", "Product Failed to save");
		}
		mv.setViewName("data");
		
		mv.addObject("pobj", new Product());
		return mv;
	}

	@GetMapping("/products")
	public ModelAndView viewProducts() {
		
		List<Product> productsList = productService.getAllProducts();
		ModelAndView mav = new ModelAndView();
		mav.addObject("plist", productsList);
		mav.setViewName("data");

		return mav;
		
	}
}
