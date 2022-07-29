package com.example.webthymeleaf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webthymeleaf.entity.Product;
import com.example.webthymeleaf.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	
		@Autowired
		private ProductService productService;
		
		@GetMapping("/productList")
		public String findAll(Model model)
		{
			List<Product> product = productService.findAll();
			model.addAttribute("PRODUCT",product);
			return "products.html";
		}
		
		@GetMapping("/addProduct")
		public String productForm(Model model) {
			model.addAttribute("PRODUCT",new Product());
			return "ProductForm.html";
		}
		
		@PostMapping("/save")
		public String save(@ModelAttribute("PRODUCT") Product product) {
			
			productService.save(product);
			
			return "redirect:/product/productList";
		}
		
		
		@GetMapping("/updateForm")
		public String updateForm(@RequestParam("productid") Integer id, Model model) {
			Product product = productService.findById(id);
			model.addAttribute("PRODUCT",product);
			return "ProductForm.html";
		}
		
		@GetMapping("/delete")
		public String deleteById(@RequestParam("productid") Integer id) {
			productService.deleteById(id);
			
			return "redirect:/product/productList";
		}
		
		@GetMapping("/search")
	    public String Search(Model model,@RequestParam("keyword") String keyword) {
	        List<Product> listProducts = productService.listAll(keyword);
	        model.addAttribute("listProducts", listProducts);
	        model.addAttribute("keyword", keyword);
	        return "index";
	    }
		
}

