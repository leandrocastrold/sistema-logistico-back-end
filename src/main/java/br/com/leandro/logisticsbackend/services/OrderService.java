package br.com.leandro.logisticsbackend.services;

import br.com.leandro.logisticsbackend.entities.OrderModel;
import br.com.leandro.logisticsbackend.repositories.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements CrudMethods<OrderModel> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Page<OrderModel> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public OrderModel getById(int id) {
        return verifyIfOrderExists(id);
    }

    @Override
    public OrderModel create(OrderModel entity) {
        return orderRepository.save(entity);
    }

    @Override
    public OrderModel update(int id, OrderModel entity) {
        OrderModel orderModelToUpdate =  verifyIfOrderExists(id);
        BeanUtils.copyProperties(entity, orderModelToUpdate);
        orderModelToUpdate.setId(id);
       return orderRepository.save(orderModelToUpdate);
    }

    public OrderModel patch(int id, OrderModel orderModel) {
        OrderModel order = verifyIfOrderExists(id);
        order.setStatus(orderModel.getStatus());
        System.out.println(order);
        return orderRepository.save(order);
    }

    @Override
    public void delete(int id) {
       OrderModel orderModelToDelete = verifyIfOrderExists(id);
       orderRepository.delete(orderModelToDelete);
    }


    private OrderModel verifyIfOrderExists(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }


}
