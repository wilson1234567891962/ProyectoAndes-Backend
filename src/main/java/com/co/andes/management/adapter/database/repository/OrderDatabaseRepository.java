package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.OrderRepositoryJPA;
import com.co.andes.management.domain.repository.OrderRepository;
import com.co.andes.management.domain.repository.model.database.OrderPurchaseEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDatabaseRepository implements OrderRepository {
	final static Logger logger = Logger.getLogger(OrderDatabaseRepository.class);

	private final OrderRepositoryJPA orderRepositoryJPA;

	@Autowired
	public OrderDatabaseRepository(OrderRepositoryJPA orderRepositoryJPA) {
		this.orderRepositoryJPA = orderRepositoryJPA;
	}

	@Override
	public List<OrderPurchaseEntity> getAllOrders() {
		return this.orderRepositoryJPA.findAll();
	}

	@Override
	public OrderPurchaseEntity getOrderById(int id) {
		return this.orderRepositoryJPA.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		 this.orderRepositoryJPA.deleteById(id);
	}
}
