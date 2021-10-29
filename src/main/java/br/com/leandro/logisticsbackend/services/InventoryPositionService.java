package br.com.leandro.logisticsbackend.services;
import br.com.leandro.logisticsbackend.entities.InventoryPosition;
import br.com.leandro.logisticsbackend.repositories.InventoryPositionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryPositionService implements CrudMethods<InventoryPosition> {

    @Autowired
    private InventoryPositionRepository positionRepository;


    @Override
    public Page<InventoryPosition> getAll(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public InventoryPosition getById(int id) {
        Optional<InventoryPosition> optional = positionRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return new InventoryPosition();
    }

    @Override
    public InventoryPosition create(InventoryPosition entity) {
        return positionRepository.save(entity);
    }

    @Override
    public InventoryPosition update(int id, InventoryPosition entity) {
        System.out.println("SEPARAÇÃO: " + entity);
        InventoryPosition positionToUpdate = verifyIfPositionExists(id);
        BeanUtils.copyProperties(entity, positionToUpdate);
        positionToUpdate.setId(id);
        return positionRepository.save(positionToUpdate);
    }

    @Override
    public void delete(int id) {
        InventoryPosition positionToDelete = verifyIfPositionExists(id);
        positionRepository.delete(positionToDelete);
    }

    public InventoryPosition getPositionByProductId(int id) {
        return positionRepository.getPositionById(id);
    }

    public InventoryPosition patch(int id, InventoryPosition quantity) {
        InventoryPosition position = verifyIfPositionExists(id);
        int availableQuantity = position.getAvailableQuantity() + quantity.getAvailableQuantity();
        position.setAvailableQuantity(availableQuantity);
        return positionRepository.save(position);
    }


    private InventoryPosition verifyIfPositionExists(int id) {
        return positionRepository.findById(id).orElseThrow( () -> new RuntimeException("Posição não encontrada"));
    }

}
