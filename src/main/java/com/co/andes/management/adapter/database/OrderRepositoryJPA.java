package com.co.andes.management.adapter.database;
import com.co.andes.management.domain.repository.model.database.OrderPurchaseEntity;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryJPA extends JpaRepository<OrderPurchaseEntity, Integer> {
	final static Logger logger = Logger.getLogger(OrderRepositoryJPA.class);
}
