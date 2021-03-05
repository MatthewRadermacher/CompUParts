package com.matthewradermacher.compuparts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matthewradermacher.compuparts.dao.ProductRepository;
import com.matthewradermacher.compuparts.dto.ProductCatalog;
import com.matthewradermacher.compuparts.entities.Product;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	@GetMapping
	public String displayProductPage(Model model) {
		List<Product> products = productRepo.findAll();
		model.addAttribute("products", products);
		return "products/product_page";
	}
	
	@GetMapping("/specific")
	public String displaySpecificProduct(Model model, @RequestParam(value="id") int id) {
		
		ProductCatalog proCatalog = productRepo.findById(id);
		model.addAttribute("proCatalog", proCatalog);
		
		return "products/product";
	}
	
	@GetMapping("/purchase")
	public String purchaseProduct(Model model, @RequestParam(value="id") int id) {
		
		productRepo.tryPurchase(id);
		return "redirect:/products";
	}
}
