package com.co.andes.management.domain.service;

import com.co.andes.management.domain.repository.OrderRepository;
import com.co.andes.management.domain.repository.model.database.ClientEntity;
import com.co.andes.management.domain.repository.model.database.OrderPurchaseEntity;

import com.co.andes.management.domain.repository.model.database.enums.FinanceEnum;
import com.co.andes.management.domain.service.model.response.DataResponseDTO;
import com.co.andes.management.domain.service.model.response.order.OrderResponseDTO;

import com.co.andes.management.utils.exception.AndesException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    final static Logger logger = Logger.getLogger(OrderService.class);
    private OrderRepository orderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public DataResponseDTO executeGetOrders(String token) throws AndesException{
        /** if (!token.startsWith("Bearer ") || JwtUtils.decodeJWTAnExtend(token.substring(7)).isEmpty()) {
            throw new AndesException(AndesErrorEnum.GENERIC_ERROR.getCode());
        }**/
        List<OrderPurchaseEntity> stores = orderRepository.getAllOrders();
        List<OrderResponseDTO> orderResponseDTO = new ArrayList<>();
        for(int i=0; i< stores.size(); i++){
            OrderPurchaseEntity storeEntity = stores.get(i);
            for(int j = 0; j < storeEntity.getClient().size(); j++){
               ClientEntity client = storeEntity.getClient().get(j);
               if(!client.getFinance().equals(FinanceEnum.BLOCKED.getState())){
                   OrderResponseDTO dto = new OrderResponseDTO(storeEntity.getId(), client.getNames(), client.getAddress(), client.getPhone(), client.getFinance());
                   orderResponseDTO.add(dto);
               }
            }
        }

        return new DataResponseDTO(orderResponseDTO);
    }
}