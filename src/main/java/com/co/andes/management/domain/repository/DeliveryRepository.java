package com.co.andes.management.domain.repository;
import com.co.andes.management.domain.repository.model.database.DeliveryPurchaseEntity;
import com.co.andes.management.domain.repository.model.database.OrderPurchaseEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeliveryRepository {

	final static Logger logger = Logger.getLogger(DeliveryRepository.class);
	DeliveryPurchaseEntity insertOrder(DeliveryPurchaseEntity deliveryPurchaseEntity);
	List<DeliveryPurchaseEntity> getAllOrdersDelivery();
}
