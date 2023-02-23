package com.co.andes.management.domain.repository;
import com.co.andes.management.domain.repository.model.database.DriverEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DriverRepository {

	final static Logger logger = Logger.getLogger(DriverRepository.class);
	List<DriverEntity> getAllDriver();
	DriverEntity getDriverById(int id);
}
