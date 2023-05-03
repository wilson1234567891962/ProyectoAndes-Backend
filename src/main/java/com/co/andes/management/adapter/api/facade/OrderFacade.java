package com.co.andes.management.adapter.api.facade;
import com.co.andes.management.domain.service.OrderService;
import com.co.andes.management.domain.service.StoreService;
import com.co.andes.management.domain.service.model.request.OrdersRequestDTO;
import com.co.andes.management.domain.service.model.request.delivery.DeliveryRequestDTO;
import com.co.andes.management.domain.service.model.request.order.OrderRequestDTO;
import com.co.andes.management.utils.exception.AndesException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFacade {


    final static Logger logger = Logger.getLogger(OrderFacade.class);

    private OrderService orderService;

    @Autowired
    public OrderFacade(OrderService orderService) {
    	this.orderService = orderService;
    }
    
    public Object executeGetOrder(String token) throws AndesException {
        return  this.orderService.executeGetOrders(token);
    }

    public Object executeGetDriver(String token) throws AndesException {
        return  this.orderService.executeGetDrivers(token);
    }

    public Object executeGetClient(String token) throws AndesException {
        return  this.orderService.executeGetAllClient(token);
    }

    public Object executeGetOrdersDelivery(String token) throws AndesException {
        return  this.orderService.executeGetAllOrdersDelivery(token);
    }

    public Object executeUpdateDeliveryPurchase(String token, DeliveryRequestDTO deliveryRequestDTO) throws AndesException {
        return  this.orderService.executeDeliveryOrderPurchase(token, deliveryRequestDTO);
    }

    public Object executeUpdateOrder(String token, List<OrderRequestDTO> orderRequestDTO) throws AndesException {
        return  this.orderService.executeUpdateOrder(token,  orderRequestDTO);
    }
}
