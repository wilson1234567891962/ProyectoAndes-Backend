package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.RolesRepositoryJPA;
import com.co.andes.management.adapter.database.UserRepositoryJPA;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.AuditEntity;
import com.co.andes.management.domain.repository.model.database.RolesEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDatabaseRepository implements UserRepository {
	final static Logger logger = Logger.getLogger(UserDatabaseRepository.class);

	private final UserRepositoryJPA userRepositoryJPA;
	private final RolesRepositoryJPA rolesRepositoryJPA;

	@Autowired
	public UserDatabaseRepository(UserRepositoryJPA userRepositoryJPA, RolesRepositoryJPA rolesRepositoryJPA) {
		this.userRepositoryJPA = userRepositoryJPA;
		this.rolesRepositoryJPA = rolesRepositoryJPA;
	}

	@Override
	public Optional<UserEntity> getUserByPasswordAndUser(String user, String password) {
		Optional<UserEntity> users= this.userRepositoryJPA.findByEmailAndPassword(user,password);
		return users;
	}

	@Override
	public Optional<UserEntity> getUserByEmail(String email) {
		Optional<UserEntity> users= this.userRepositoryJPA.findByEmail(email);
		return users;
	}

	@Override
	public UserEntity saveUser(String email, String password, int status, List<AuditEntity> audit) {
		Optional<RolesEntity> rolDB = this.rolesRepositoryJPA.findById(1);
		UserEntity user = new UserEntity(null, email, password, status, rolDB.get(), audit);
		UserEntity ustTmp = this.userRepositoryJPA.save(user);
		return ustTmp;
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		return this.userRepositoryJPA.save(userEntity);
	}

	@Override
	public UserEntity findById(int id) {
		return this.userRepositoryJPA.findById(id).get();
	}
}
