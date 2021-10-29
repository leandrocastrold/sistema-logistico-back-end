package br.com.leandro.logisticsbackend.controllers;

import br.com.leandro.logisticsbackend.entities.OrderModel;
import br.com.leandro.logisticsbackend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/separacoes")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @GetMapping
    public Page<OrderModel> getAll(Pageable pageable) {
        return orderService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public OrderModel getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @CrossOrigin
    @PostMapping
    public OrderModel create(@RequestBody OrderModel orderModel) {
        return orderService.create(orderModel);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public OrderModel update(@PathVariable int id, @RequestBody OrderModel orderModel) {
        return orderService.update(id, orderModel);
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    public OrderModel patch(@PathVariable int id, @RequestBody OrderModel orderModel) {
        return orderService.patch(id, orderModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }


}
