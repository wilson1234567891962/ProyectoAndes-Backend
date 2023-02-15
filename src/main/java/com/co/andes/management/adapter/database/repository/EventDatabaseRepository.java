package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.AuditRepositoryJPA;
import com.co.andes.management.adapter.database.RolesRepositoryJPA;
import com.co.andes.management.adapter.database.UserRepositoryJPA;
import com.co.andes.management.domain.repository.AuditRepository;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.AuditEntity;
import com.co.andes.management.domain.repository.model.database.RolesEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import com.co.andes.management.domain.repository.model.database.enums.EventEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public class EventDatabaseRepository implements AuditRepository {
	final static Logger logger = Logger.getLogger(EventDatabaseRepository.class);

	private final AuditRepositoryJPA auditRepositoryJPA;

	@Autowired
	public EventDatabaseRepository(AuditRepositoryJPA auditRepositoryJPA) {
		this.auditRepositoryJPA = auditRepositoryJPA;
	}

	@Override
	@Async
	public void sendRegisterEvent(String email, String token, EventEnum description, Date date) {
		this.auditRepositoryJPA.save(new AuditEntity(null, token, email, description, date));
	}
}
