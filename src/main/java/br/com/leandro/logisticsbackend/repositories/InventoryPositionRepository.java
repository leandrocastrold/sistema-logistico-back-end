package br.com.leandro.logisticsbackend.repositories;
import br.com.leandro.logisticsbackend.entities.InventoryPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryPositionRepository extends JpaRepository<InventoryPosition, Integer> {

    @Query("SELECT p FROM InventoryPosition p WHERE p.product.id = ?1")
    InventoryPosition getPositionById(int id);
}
