package com.co.andes.management.adapter.database;

import com.co.andes.management.domain.repository.model.database.RolesEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Integer> {
	final static Logger logger = Logger.getLogger(UserRepositoryJPA.class);

	Optional<UserEntity> findByEmailAndPassword(String email, String password);

	Optional<UserEntity> findByEmail(String email);

}
