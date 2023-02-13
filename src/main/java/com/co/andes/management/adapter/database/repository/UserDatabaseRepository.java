package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.UserRepositoryJPA;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDatabaseRepository implements UserRepository {
	final static Logger logger = Logger.getLogger(UserDatabaseRepository.class);

	private final UserRepositoryJPA userRepositoryJPA;

	@Autowired
	public UserDatabaseRepository(UserRepositoryJPA userRepositoryJPA) {
		this.userRepositoryJPA = userRepositoryJPA;
	}

	@Override
	public Optional<UserEntity> getUserByPasswordAndUser(String user, String password) {
		Optional<UserEntity> users= this.userRepositoryJPA.findByEmailAndPassword(user,password);
		return users;
	}
}
