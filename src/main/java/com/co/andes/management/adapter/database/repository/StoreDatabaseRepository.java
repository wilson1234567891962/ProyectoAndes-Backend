package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.RolesRepositoryJPA;
import com.co.andes.management.adapter.database.StoreRepositoryJPA;
import com.co.andes.management.adapter.database.UserRepositoryJPA;
import com.co.andes.management.domain.repository.StoreRepository;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.AuditEntity;
import com.co.andes.management.domain.repository.model.database.RolesEntity;
import com.co.andes.management.domain.repository.model.database.StoreEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StoreDatabaseRepository implements StoreRepository {
	final static Logger logger = Logger.getLogger(StoreDatabaseRepository.class);

	private final StoreRepositoryJPA storeRepositoryJPA;

	@Autowired
	public StoreDatabaseRepository(StoreRepositoryJPA storeRepositoryJPA) {
		this.storeRepositoryJPA = storeRepositoryJPA;
	}


	@Override
	public List<StoreEntity> getAllStores() {
		return this.storeRepositoryJPA.findAll();
	}
}
