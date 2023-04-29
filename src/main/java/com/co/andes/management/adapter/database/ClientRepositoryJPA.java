package com.co.andes.management.adapter.database;
import com.co.andes.management.domain.repository.model.database.ClientEntity;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryJPA extends JpaRepository<ClientEntity, Integer> {
	final static Logger logger = Logger.getLogger(ClientRepositoryJPA.class);
}
