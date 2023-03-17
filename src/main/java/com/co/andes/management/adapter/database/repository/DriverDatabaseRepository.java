package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.DriverRepositoryJPA;
import com.co.andes.management.domain.repository.DriverRepository;
import com.co.andes.management.domain.repository.model.database.DriverEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DriverDatabaseRepository implements DriverRepository {
	final static Logger logger = Logger.getLogger(DriverDatabaseRepository.class);

	private final DriverRepositoryJPA driverRepositoryJPA;

	@Autowired
	public DriverDatabaseRepository(DriverRepositoryJPA driverRepositoryJPA) {
		this.driverRepositoryJPA = driverRepositoryJPA;
	}

	@Override
	public List<DriverEntity> getAllDriver() {
		return driverRepositoryJPA.findAll();
	}

	@Override
	public DriverEntity getDriverById(int id) {
		return driverRepositoryJPA.findById(id).get();
	}
}
