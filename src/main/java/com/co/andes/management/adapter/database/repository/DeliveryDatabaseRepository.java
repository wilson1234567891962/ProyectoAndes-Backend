package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.DeliveryPurchaseRepositoryJPA;
import com.co.andes.management.adapter.database.OrderRepositoryJPA;
import com.co.andes.management.domain.repository.DeliveryRepository;
import com.co.andes.management.domain.repository.model.database.DeliveryPurchaseEntity;
import com.co.andes.management.domain.repository.model.database.OrderPurchaseEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryDatabaseRepository implements DeliveryRepository {
	final static Logger logger = Logger.getLogger(DeliveryDatabaseRepository.class);

	private final OrderRepositoryJPA orderRepositoryJPA;
	private final DeliveryPurchaseRepositoryJPA deliveryPurchase;

	@Autowired
	public DeliveryDatabaseRepository(OrderRepositoryJPA orderRepositoryJPA, DeliveryPurchaseRepositoryJPA deliveryPurchase) {
		this.orderRepositoryJPA = orderRepositoryJPA;
		this.deliveryPurchase = deliveryPurchase;
	}

	@Override
	public DeliveryPurchaseEntity insertOrder(OrderPurchaseEntity orderPurchaseEntity) {
		return null;
	}
}
