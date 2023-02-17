package com.co.andes.management.domain.service;

import com.co.andes.management.domain.repository.AuditRepository;
import com.co.andes.management.domain.repository.StoreRepository;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.StoreEntity;
import com.co.andes.management.domain.service.model.response.DataResponseDTO;
import com.co.andes.management.domain.service.model.response.login.LoginResponseDTO;
import com.co.andes.management.domain.service.model.response.store.StoreResponseDTO;
import com.co.andes.management.utils.exception.AndesErrorEnum;
import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.utils.token.JwtUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (!token.startsWith("Bearer ") || JwtUtils.decodeJWTAnExtend(token.substring(7)).isEmpty()) {
            throw new AndesException(AndesErrorEnum.GENERIC_ERROR.getCode());
        }
        List<StoreEntity> stores = store.getAllStores();
        return new DataResponseDTO(new StoreResponseDTO(stores));
    }
}