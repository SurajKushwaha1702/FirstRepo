package com.springbootJPA.crudFunction.service;

import com.springbootJPA.crudFunction.dao.Dao;
import com.springbootJPA.crudFunction.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private Dao dao;

    @Override
    public List<Product> showProduct() {
        return dao.showProducts();
    }

    @Override
    public Product saveProduct(Product pro) {
        return dao.saveProducts(pro);
    }

    @Override
    public String deleteProduct(int id) {
        return dao.deleteProducts(id);
    }

    @Override
    public String updateProduct(Product pro, int id) {
        
        return dao.updateProducts(pro, id);
    }
}
