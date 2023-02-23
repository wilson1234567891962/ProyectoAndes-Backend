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

	private final DeliveryPurchaseRepositoryJPA deliveryPurchase;

	@Autowired
	public DeliveryDatabaseRepository(DeliveryPurchaseRepositoryJPA deliveryPurchase) {
		this.deliveryPurchase = deliveryPurchase;
	}

	@Override
	public DeliveryPurchaseEntity insertOrder(DeliveryPurchaseEntity deliveryPurchaseEntity) {
		return this.deliveryPurchase.save(deliveryPurchaseEntity);
	}
}
