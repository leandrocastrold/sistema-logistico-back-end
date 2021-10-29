package br.com.leandro.logisticsbackend.controllers;

import br.com.leandro.logisticsbackend.entities.InventoryPosition;
import br.com.leandro.logisticsbackend.services.InventoryPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory-positions")
@CrossOrigin
public class InventoryPositionController {

    @Autowired
    private InventoryPositionService positionService;

    @GetMapping
    public Page<InventoryPosition> getAll(Pageable pageable) {
        return positionService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public InventoryPosition getById(@PathVariable int id) {
        return positionService.getById(id);
    }

    @PostMapping
    public InventoryPosition create(@RequestBody InventoryPosition position) {
        return positionService.create(position);
    }

    @PutMapping("/{id}")
    public InventoryPosition update(@PathVariable int id, @RequestBody InventoryPosition position) {
        return positionService.update(id, position);
    }

    @CrossOrigin
    @PatchMapping("/{id}/quantity")
    public InventoryPosition patch(@PathVariable int id, @RequestBody InventoryPosition quantity) {
        return positionService.patch(id, quantity);
    }

    @CrossOrigin
    @DeleteMapping("/{id}/remocao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        positionService.delete(id);
    }

    @GetMapping("product/{id}")
    public InventoryPosition getPositionByProductId(@PathVariable int id) {
        return positionService.getPositionByProductId(id);
    }


}
