package com.co.andes.management.adapter.api.facade;
import com.co.andes.management.domain.service.LoginService;
import com.co.andes.management.domain.service.StoreService;
import com.co.andes.management.domain.service.model.request.LoginRequestDTO;
import com.co.andes.management.utils.exception.AndesException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreFacade {


    final static Logger logger = Logger.getLogger(StoreFacade.class);

    private StoreService storeService;

    @Autowired
    public StoreFacade( StoreService storeService) {
    	this.storeService = storeService;
    }
    
    public Object executeGetStore(String token) throws AndesException {
        return  this.storeService.getStoreProduct(token);
    }
}
