package com.co.andes.management.adapter.database;

import com.co.andes.management.domain.repository.model.database.StoreEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepositoryJPA extends JpaRepository<StoreEntity, Integer> {
	final static Logger logger = Logger.getLogger(StoreRepositoryJPA.class);
}
