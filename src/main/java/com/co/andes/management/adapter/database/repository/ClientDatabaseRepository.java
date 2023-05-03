package com.co.andes.management.adapter.database.repository;

import com.co.andes.management.adapter.database.ClientRepositoryJPA;
import com.co.andes.management.domain.repository.ClientRepository;
import com.co.andes.management.domain.repository.model.database.ClientEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDatabaseRepository implements ClientRepository {
	final static Logger logger = Logger.getLogger(ClientDatabaseRepository.class);

	private final ClientRepositoryJPA clientRepositoryJPA;

	@Autowired
	public ClientDatabaseRepository(ClientRepositoryJPA clientRepositoryJPA) {
		this.clientRepositoryJPA = clientRepositoryJPA;
	}


	@Override
	public List<ClientEntity> getAllCLients() {
		return this.clientRepositoryJPA.findAll();
	}

	@Override
	public ClientEntity findById(int id) {
		return this.clientRepositoryJPA.findById(id).get();
	}
}
