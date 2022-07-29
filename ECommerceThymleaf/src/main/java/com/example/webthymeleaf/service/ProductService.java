package com.example.webthymeleaf.service;

import java.util.List;

import com.example.webthymeleaf.entity.Product;


public interface ProductService
{
	public List<Product> findAll();
	public void save(Product product);
	public void deleteById(Integer id);
	public Product findById(Integer id);
	public Product findByName(String name);
	public List<Product> listAll(String keyword);
	
}
