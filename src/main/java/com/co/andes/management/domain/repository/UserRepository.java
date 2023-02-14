package com.co.andes.management.domain.repository;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository {

	final static Logger logger = Logger.getLogger(UserRepository.class);
	Optional<UserEntity> getUserByPasswordAndUser(String user, String password);
	Optional<UserEntity> getUserByEmail(String email);
	boolean saveUser(String email, String password, int status);

}
