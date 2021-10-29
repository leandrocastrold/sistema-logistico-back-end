package br.com.leandro.logisticsbackend.controllers;

import br.com.leandro.logisticsbackend.entities.Product;
import br.com.leandro.logisticsbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAll(Pageable pageable) {
        return productService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}/remocao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        System.out.println("Deleting");
        productService.delete(id);
    }

}
