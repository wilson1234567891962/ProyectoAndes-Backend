package com.co.andes.management.domain.repository;
import com.co.andes.management.domain.repository.model.database.AuditEntity;
import com.co.andes.management.domain.repository.model.database.enums.EventEnum;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public interface AuditRepository {

	final static Logger logger = Logger.getLogger(AuditRepository.class);


	AuditEntity sendRegisterEvent(String token, EventEnum description, Date date);

}
