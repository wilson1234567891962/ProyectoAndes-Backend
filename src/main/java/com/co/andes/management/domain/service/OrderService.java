package com.co.andes.management.domain.service;

import com.co.andes.management.domain.repository.*;
import com.co.andes.management.domain.repository.model.database.*;
import com.co.andes.management.domain.repository.model.database.enums.FinanceEnum;
import com.co.andes.management.domain.repository.model.database.enums.StateEnum;
import com.co.andes.management.domain.service.model.request.order.OrderRequestDTO;
import com.co.andes.management.domain.service.model.response.DataResponseDTO;
import com.co.andes.management.domain.service.model.response.client.ClientResponseDTO;
import com.co.andes.management.domain.service.model.response.driver.DriverResponseDTO;
import com.co.andes.management.domain.service.model.response.order.DetailOrderResponseDTO;
import com.co.andes.management.domain.service.model.response.order.OrderResponseDTO;
import com.co.andes.management.utils.Utils;
import com.co.andes.management.utils.exception.AndesErrorEnum;
import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.utils.exception.ConstantErrors;
import com.co.andes.management.utils.token.JwtUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    final static Logger logger = Logger.getLogger(OrderService.class);
    private ClientRepository clientRepository;
    private OrderRepository orderRepository;
    private DeliveryRepository deliveryRepository;
    private DriverRepository driverRepository;
    private StoreRepository store;

    @Autowired
    public OrderService(OrderRepository orderRepository, DeliveryRepository deliveryRepository, DriverRepository driverRepository, StoreRepository storeRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.deliveryRepository = deliveryRepository;
        this.driverRepository = driverRepository;
        this.store = storeRepository;
        this.clientRepository = clientRepository;
    }

    public DataResponseDTO executeGetOrders(String token) throws AndesException{
        Utils.checkToken(token);

        List<OrderPurchaseEntity> stores = orderRepository.getAllOrders();
        List<OrderResponseDTO> orderResponseDTO = new ArrayList<>();
        for(OrderPurchaseEntity it : stores){
            if(!it.getClient().getFinance().equals(FinanceEnum.BLOCKED.getState())){
                DetailOrderResponseDTO det = new DetailOrderResponseDTO(it.getStore().getId(), it.getStore().getProduct().getName(), it.getStore().getAmount());
                OrderResponseDTO or = new OrderResponseDTO(it.getId(), it.getClient().getNames(), it.getClient().getAddress(), it.getClient().getPhone(), it.getState().getState(), it.getAmount(),  det);
                orderResponseDTO.add(or);
            }

        }

        return new DataResponseDTO(orderResponseDTO);
    }

    public DataResponseDTO executeGetDrivers(String token) throws AndesException{
        Utils.checkToken(token);
        List<DriverEntity> driver = driverRepository.getAllDriver();
        List<DriverResponseDTO> driverResponseDTO = new ArrayList<>();
        for(DriverEntity it : driver){
            DriverResponseDTO det = new DriverResponseDTO(it.getId(), it.getDocument(),it.getDriverName());
            driverResponseDTO.add(det);
        }

        return new DataResponseDTO(driverResponseDTO);
    }

    public DataResponseDTO executeGetAllClient(String token) throws AndesException{
        Utils.checkToken(token);
        List<ClientEntity> client = clientRepository.getAllCLients();
        List<ClientResponseDTO> clientResponseDTO = new ArrayList<>();
        for(ClientEntity it : client){
            ClientResponseDTO det = new ClientResponseDTO(it.getId(), it.getNames());
            clientResponseDTO.add(det);
        }

        return new DataResponseDTO(clientResponseDTO);
    }


    public DataResponseDTO executeUpdateOrder(String token, List<OrderRequestDTO> orderRequestDTO) throws AndesException{
        Utils.checkToken(token);
        for(OrderRequestDTO it : orderRequestDTO){
            OrderPurchaseEntity order = this.orderRepository.getOrderById(it.getIdOrder());
            DriverEntity driver = this.driverRepository.getDriverById(it.getDriver());
            StoreEntity store = this.store.findById(it.getDetail().getIdStore());
            store.setAmount(store.getAmount() - it.getAmount());
            StateEnum state = it.getState().equals(StateEnum.PROCESSED) ? StateEnum.PROCESSED : it.getState().equals(StateEnum.CANCELED) ? StateEnum.CANCELED : StateEnum.EXECUTING;
            DeliveryPurchaseEntity delivery = new DeliveryPurchaseEntity(null, it.getAmount(), state, order.getClient(), order.getUserEntity(), order.getStore(), driver);
            this.orderRepository.deleteById(it.getIdOrder());
            this.deliveryRepository.insertOrder(delivery);
            this.store.updateStore(store);
            this.orderRepository.deleteById(it.getIdOrder());
            this.deliveryRepository.insertOrder(delivery);
            this.store.updateStore(store);
        }
        DataResponseDTO dataResponseDTO= new DataResponseDTO();
        dataResponseDTO.setData(ConstantErrors.ERRORS_STATES.get(AndesErrorEnum.SUCCESS_TRANSACTION.getCode()));
        return dataResponseDTO;
    }
}