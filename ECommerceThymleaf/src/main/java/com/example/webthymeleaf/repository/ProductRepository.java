package com.example.webthymeleaf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.webthymeleaf.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{
	public List<Product> findAll();
	@Query("SELECT p FROM Product p WHERE CONCAT(p.id, ' ', p.name, ' ', p.unitprice, ' ', p.datecreated) LIKE %?1%")
	public Optional<Product> findByName(String name);
	public List<Product> search(String keyword);
}
