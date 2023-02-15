package com.co.andes.management.adapter.database;

import com.co.andes.management.domain.repository.model.database.AuditEntity;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepositoryJPA extends JpaRepository<AuditEntity, Integer> {
	final static Logger logger = Logger.getLogger(AuditRepositoryJPA.class);

}
