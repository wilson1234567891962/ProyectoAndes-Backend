package com.co.andes.management.domain.repository;
import com.co.andes.management.domain.repository.model.database.ClientEntity;
import com.co.andes.management.domain.repository.model.database.StoreEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientRepository {

	final static Logger logger = Logger.getLogger(ClientRepository.class);
	List<ClientEntity> getAllCLients();
	ClientEntity findById(int id);
}
