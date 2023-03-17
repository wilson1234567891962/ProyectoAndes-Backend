package com.co.andes.management.adapter.database;

import com.co.andes.management.domain.repository.model.database.RolesEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepositoryJPA extends JpaRepository<RolesEntity, Integer> {
	final static Logger logger = Logger.getLogger(RolesRepositoryJPA.class);

	Optional<RolesEntity> findById(int id);

}
