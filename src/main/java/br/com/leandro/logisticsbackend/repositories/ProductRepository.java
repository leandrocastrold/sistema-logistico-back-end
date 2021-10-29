package br.com.leandro.logisticsbackend.repositories;

import br.com.leandro.logisticsbackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
