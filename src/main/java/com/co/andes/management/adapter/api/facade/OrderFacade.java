package com.co.andes.management.adapter.api.facade;
import com.co.andes.management.domain.service.OrderService;
import com.co.andes.management.domain.service.StoreService;
import com.co.andes.management.utils.exception.AndesException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
