package com.co.andes.management.adapter.database;
import com.co.andes.management.domain.repository.model.database.DeliveryPurchaseEntity;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPurchaseRepositoryJPA extends JpaRepository<DeliveryPurchaseEntity, Integer> {
	final static Logger logger = Logger.getLogger(DeliveryPurchaseRepositoryJPA.class);
}
