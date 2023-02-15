package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.AuditRepositoryJPA;
import com.co.andes.management.adapter.database.RolesRepositoryJPA;
import com.co.andes.management.adapter.database.UserRepositoryJPA;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.AuditEntity;
import com.co.andes.management.domain.repository.model.database.RolesEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import com.co.andes.management.domain.repository.model.database.enums.EventEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public class UserDatabaseRepository implements UserRepository {
	final static Logger logger = Logger.getLogger(UserDatabaseRepository.class);

	private final UserRepositoryJPA userRepositoryJPA;
	private final RolesRepositoryJPA rolesRepositoryJPA;
	private final AuditRepositoryJPA auditRepositoryJPA;

	@Autowired
	public UserDatabaseRepository(UserRepositoryJPA userRepositoryJPA, RolesRepositoryJPA rolesRepositoryJPA, AuditRepositoryJPA auditRepositoryJPA) {
		this.userRepositoryJPA = userRepositoryJPA;
		this.rolesRepositoryJPA = rolesRepositoryJPA;
		this.auditRepositoryJPA = auditRepositoryJPA;
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
	public boolean saveUser(String email, String password, int status) {
		Optional<RolesEntity> rolDB = this.rolesRepositoryJPA.findById(1);
		this.auditRepositoryJPA.save(new AuditEntity(null, "", EventEnum.REGISTER_USER, new Date()));
		this.userRepositoryJPA.save(new UserEntity(null, email, password, status, rolDB.get()));
		return true;
	}
}
