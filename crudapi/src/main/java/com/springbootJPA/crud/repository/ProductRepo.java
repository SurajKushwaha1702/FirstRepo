package com.springbootJPA.crudFunction.repository;

import com.springbootJPA.crudFunction.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {
}
