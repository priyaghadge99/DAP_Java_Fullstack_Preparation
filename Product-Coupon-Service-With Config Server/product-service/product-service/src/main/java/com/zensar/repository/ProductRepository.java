package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Product;

//@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
