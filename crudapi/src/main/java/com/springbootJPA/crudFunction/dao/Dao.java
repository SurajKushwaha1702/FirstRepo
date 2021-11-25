package com.springbootJPA.crudFunction.dao;

import com.springbootJPA.crudFunction.entity.Product;
import com.springbootJPA.crudFunction.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Dao {
    @Autowired
    private ProductRepo repo;

    public List<Product> showProducts ()
    {
        List<Product> pro = new ArrayList<>();
//        repo.findAll().forEach(product -> pro.add(product));
        Iterable<Product> iterable =repo.findAll();
            for (Product product : iterable) {
                pro.add(product);
            }

        return pro;
    }

    public Product saveProducts(Product pro)
    {
        repo.save(pro);
        return pro;
    }

    public String deleteProducts(int id)
    {
        repo.deleteById(id);
        return "Deleted...";
    }

    public String updateProducts(Product pro, int id)
    {
        Product productofDB = repo.findById(id).get();
        productofDB.setName(pro.getName());
        productofDB.setQuantity(pro.getQuantity());
        productofDB.setPrice(pro.getPrice());
        repo.save(productofDB);
        return "Updated....";
    }
}
