package br.com.leandro.logisticsbackend.repositories;

import br.com.leandro.logisticsbackend.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer> {
}
