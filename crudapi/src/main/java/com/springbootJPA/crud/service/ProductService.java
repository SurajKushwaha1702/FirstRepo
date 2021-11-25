package com.springbootJPA.crudFunction.service;

import com.springbootJPA.crudFunction.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    String deleteProduct(int id);
    String updateProduct(Product product,int id);
    List<Product> showProduct();

}
