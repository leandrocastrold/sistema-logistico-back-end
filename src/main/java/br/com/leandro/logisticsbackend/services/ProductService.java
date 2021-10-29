package br.com.leandro.logisticsbackend.services;

import br.com.leandro.logisticsbackend.entities.Product;
import br.com.leandro.logisticsbackend.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements CrudMethods<Product> {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getById(int id) {
        return verifyIfProductExists(id);
    }

    @Override
    public Product create(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Product update(int id, Product entity) {
        Product productToUpdate = verifyIfProductExists(id);
        BeanUtils.copyProperties(entity, productToUpdate);
        productToUpdate.setId(id);
        return productRepository.save(productToUpdate);
    }

    @Override
    public void delete(int id) {
        Product productToDelete = verifyIfProductExists(id);
        productRepository.delete(productToDelete);
    }

    private Product verifyIfProductExists(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
