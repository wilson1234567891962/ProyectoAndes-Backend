package com.co.andes.management.domain.service;

import com.co.andes.management.domain.repository.AuditRepository;
import com.co.andes.management.domain.repository.StoreRepository;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.StoreEntity;
import com.co.andes.management.domain.service.model.response.DataResponseDTO;
import com.co.andes.management.domain.service.model.response.login.LoginResponseDTO;
import com.co.andes.management.domain.service.model.response.store.DetailResponseDTO;
import com.co.andes.management.domain.service.model.response.store.StoreResponseDTO;
import com.co.andes.management.utils.Utils;
import com.co.andes.management.utils.exception.AndesErrorEnum;
import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.utils.token.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StoreService {

    final static Logger logger = Logger.getLogger(StoreService.class);
    private StoreRepository store;


    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.store = storeRepository;
    }

    public DataResponseDTO getStoreProduct(String token) throws AndesException{
        Utils.checkToken(token);

        List<StoreEntity> stores = store.getAllStores();
        List<StoreResponseDTO> storeResponseDTO = new ArrayList<>();
        for(int i=0; i< stores.size(); i++){
            StoreEntity storeEntity = stores.get(i);
            DetailResponseDTO detailResponseDTO = new DetailResponseDTO(storeEntity.getCategory().getCategory().getCategory(), storeEntity.getExpiration(), storeEntity.getLocate().getAddress());
            StoreResponseDTO sto = new StoreResponseDTO(storeEntity.getId(),storeEntity.getProduct().getName(), storeEntity.getProduct().getImage(),
                    storeEntity.getWarehouse().getName(),storeEntity.getManufacture().getName(), storeEntity.getImporter().getName(), storeEntity.getAmount(), detailResponseDTO);
            storeResponseDTO.add(sto);
        }

        return new DataResponseDTO(storeResponseDTO);
    }
}