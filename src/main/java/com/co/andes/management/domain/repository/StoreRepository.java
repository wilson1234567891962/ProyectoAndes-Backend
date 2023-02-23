package com.co.andes.management.domain.repository;
import com.co.andes.management.domain.repository.model.database.StoreEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface StoreRepository {

	final static Logger logger = Logger.getLogger(StoreRepository.class);
	List<StoreEntity> getAllStores();
	StoreEntity findById(int id);
	StoreEntity updateStore(StoreEntity store);
}
