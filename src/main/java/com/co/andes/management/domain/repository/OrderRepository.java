package com.co.andes.management.domain.repository;
import com.co.andes.management.domain.repository.model.database.OrderPurchaseEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository {

	final static Logger logger = Logger.getLogger(OrderRepository.class);
	List<OrderPurchaseEntity> getAllOrders();
	OrderPurchaseEntity getOrderById(int id);
	void deleteById(int id);
}
