package com.co.andes.management.adapter.database;
import com.co.andes.management.domain.repository.model.database.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepositoryJPA extends JpaRepository<DriverEntity, Integer> {

}
