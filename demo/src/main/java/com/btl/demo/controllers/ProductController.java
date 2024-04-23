package com.btl.demo.controllers;

import com.btl.demo.models.Product;
import com.btl.demo.models.IResponse.ResponseObject;
import com.btl.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    List<Product> getAllProducts() {
        return repository.findAll(); //findAll co san trong repository do repository extend JPA
    }

    @GetMapping("/{id}")
        //let return a object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Integer id) {//findById co san trong repository do repository extend JPA
        Optional<Product> foundProduct = repository.findById(id);
//        if (id > 0) {
        //neu foundProduct co data ben trong
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("OK", "Query producct successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("Failed", "Can't find product with td = " + id, "")
                );
//        }
//        else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
//                new ResponseObject("OK", "Invalid id", "")
//        );
    }

    //insert
    @PostMapping("insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        //2 product must not have same name
        List<Product> foundProduct = repository.findByName(newProduct.getName().trim());
        if (foundProduct.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed", "Product name already exist !", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert product successfully !", repository.save(newProduct))
        );
    }

    //update
    @PutMapping("/update/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Integer id) {
        Product updateProduct =  repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    return repository.save(product);
                }).orElseGet(() -> {
//                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Update successfully", updateProduct)
        );
    };

    //delete
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Integer id) {
        Optional<Product> p = repository.findById(id);
        if(p.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Delete successfully", null)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("Failed", "Product is not exist", "")
        );
    };
}
