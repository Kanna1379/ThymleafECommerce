package com.example.webthymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webthymeleaf.entity.Product;
import com.example.webthymeleaf.repository.ProductRepository;


@Service
public class ProductServiceImp implements ProductService{
	@Autowired
    private ProductRepository repository;
	
	public List<Product> findAll() {
		
		return repository.findAll();
	}

	public void save(Product p) {
		 repository.save(p);	
	}


	
	public Product findById(Integer id) {
		
		Optional<Product> p =  repository.findById(id) ;
		Product product = null;
		
		if(p.isPresent())
			product = p.get();
		
		return product;
	}


	
	public void deleteById(Integer id) {
		repository.deleteById(id);
		
	}
	
	public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return repository.search(keyword);
        }
        return repository.findAll();
    }

public Product findByName(String name) {
		
		Optional<Product> p =  repository.findByName(name) ;
		Product product = null;
		
		if(p.isPresent())
			product = p.get();
		
		return product;
	}
		
}

