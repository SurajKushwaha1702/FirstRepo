package com.springbootJPA.crudFunction.controller;

import com.springbootJPA.crudFunction.entity.Product;
import com.springbootJPA.crudFunction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {

    @Autowired
    private ProductService service;

    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/show")
    private List<Product> getAll()
    {
        return service.showProduct();
    }

    @DeleteMapping("/delete/{id}")
    private String delete(@PathVariable("id") int id)
    {
        return service.deleteProduct(id);
    }

    @PostMapping("/save")
    private Product save (@RequestBody Product pro)
    {
      return service.saveProduct(pro);

    }

    @PutMapping("/update/{id}")
    private String  update(@RequestBody Product pro,@PathVariable int id)
    {
        return service.updateProduct(pro,id);
    }








































//    @RequestMapping(value="/create",method=RequestMethod.POST)
//    public Product addProduct(@RequestParam String name, @RequestParam int quantity, @RequestParam double price){
//       Product pro = new Product();
//       pro.setName(name);
//       pro.setQuantity(quantity);
//       pro.setPrice(price);
//        service.saveProduct(pro);
//        return pro;
//    }
















//    @RequestMapping(value="/create",method=RequestMethod.POST)
//    public Product addProduct(@RequestParam String name, @RequestParam int quantity, @RequestParam double price){
//       Product pro = new Product();
//       pro.setName(name);
//       pro.setQuantity(quantity);
//       pro.setPrice(price);
//        service.saveProduct(pro);
//        return pro;
//    }

//    @PostMapping("/addProduct")
//    public Product addProduct(@RequestBody Product product){
//        return service.saveProduct(product);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String removeProduct(@PathVariable int id){
//        return service.deleteProduct(id);
//    }
//

}
