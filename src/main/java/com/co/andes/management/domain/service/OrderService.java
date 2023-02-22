package com.co.andes.management.domain.service;

import com.co.andes.management.domain.repository.DeliveryRepository;
import com.co.andes.management.domain.repository.OrderRepository;
import com.co.andes.management.domain.repository.model.database.OrderPurchaseEntity;
import com.co.andes.management.domain.service.model.request.order.OrderRequestDTO;
import com.co.andes.management.domain.service.model.response.DataResponseDTO;
import com.co.andes.management.domain.service.model.response.order.DetailOrderResponseDTO;
import com.co.andes.management.domain.service.model.response.order.OrderResponseDTO;
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
public class OrderService {

    final static Logger logger = Logger.getLogger(OrderService.class);
    private OrderRepository orderRepository;
    private DeliveryRepository deliveryRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, DeliveryRepository deliveryRepository) {
        this.orderRepository = orderRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public DataResponseDTO executeGetOrders(String token) throws AndesException{

        if (!token.startsWith("Bearer ") || JwtUtils.decodeJWTAnExtend(token.substring(7)).isEmpty()) {
            throw new AndesException(AndesErrorEnum.GENERIC_ERROR.getCode());
        }

        Claims claims = JwtUtils.decodeJWT(JwtUtils.decodeJWTAnExtend(token.substring(7)));

        List<OrderPurchaseEntity> stores = orderRepository.getAllOrders();
        List<OrderResponseDTO> orderResponseDTO = new ArrayList<>();
        for(OrderPurchaseEntity it : stores){
            if(it.getUserEntity().getEmail().equals(claims.getSubject())){
                DetailOrderResponseDTO det = new DetailOrderResponseDTO(it.getStore().getId(), it.getStore().getProduct().getName(), it.getStore().getAmount());
                OrderResponseDTO or = new OrderResponseDTO(it.getId(), it.getClient().getNames(), it.getClient().getAddress(), it.getClient().getPhone(), it.getState().getRol(), it.getAmount(),  det);
                orderResponseDTO.add(or);
           }

        }

        return new DataResponseDTO(orderResponseDTO);
    }

    public DataResponseDTO executeUpdateOrder(String token, List<OrderRequestDTO> orderRequestDTO) throws AndesException{
        if (!token.startsWith("Bearer ") || JwtUtils.decodeJWTAnExtend(token.substring(7)).isEmpty()) {
          throw new AndesException(AndesErrorEnum.GENERIC_ERROR.getCode());
        }

        Claims claims = JwtUtils.decodeJWT(JwtUtils.decodeJWTAnExtend(token.substring(7)));
        List<OrderPurchaseEntity> stores = orderRepository.getAllOrders();

        List<OrderResponseDTO> orderResponseDTO = new ArrayList<>();
        for(OrderPurchaseEntity it : stores){
            if(it.getUserEntity().getEmail().equals(claims.getSubject())){
            DetailOrderResponseDTO det = new DetailOrderResponseDTO(it.getStore().getId(), it.getStore().getProduct().getName(), it.getStore().getAmount());
            OrderResponseDTO or = new OrderResponseDTO(it.getId(), it.getClient().getNames(), it.getClient().getAddress(), it.getClient().getPhone(), it.getState().getRol(), it.getAmount(),  det);
            orderResponseDTO.add(or);
             }
        }

        return new DataResponseDTO(orderResponseDTO);
    }
}