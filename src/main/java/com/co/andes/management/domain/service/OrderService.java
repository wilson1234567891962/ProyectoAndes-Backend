package com.co.andes.management.domain.service;

import com.co.andes.management.domain.repository.*;
import com.co.andes.management.domain.repository.model.database.*;
import com.co.andes.management.domain.repository.model.database.enums.FinanceEnum;
import com.co.andes.management.domain.repository.model.database.enums.StateEnum;
import com.co.andes.management.domain.service.model.request.delivery.DeliveryRequestDTO;
import com.co.andes.management.domain.service.model.request.order.OrderRequestDTO;
import com.co.andes.management.domain.service.model.response.DataResponseDTO;
import com.co.andes.management.domain.service.model.response.client.ClientResponseDTO;
import com.co.andes.management.domain.service.model.response.delivery.DeliveryResponseDTO;
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
    private StoreRepository storeRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderService(ClientRepository clientRepository, OrderRepository orderRepository, DeliveryRepository deliveryRepository, DriverRepository driverRepository, StoreRepository storeRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
        this.deliveryRepository = deliveryRepository;
        this.driverRepository = driverRepository;
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
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

    public DataResponseDTO executeGetAllOrdersDelivery(String token) throws AndesException{
        Utils.checkToken(token);
        List<DeliveryPurchaseEntity> ordersDelivery = this.deliveryRepository.getAllOrdersDelivery();
        List<DeliveryResponseDTO> deliveryResponseDTO = new ArrayList<>();
        for(DeliveryPurchaseEntity it : ordersDelivery){
            DeliveryResponseDTO det = new DeliveryResponseDTO(it.getId(), it.getAmount(),  it.getState().getState(), it.getClient().getNames());
            deliveryResponseDTO.add(det);
        }

        return new DataResponseDTO(deliveryResponseDTO);
    }

    public DataResponseDTO executeDeliveryOrderPurchase(String token, DeliveryRequestDTO deliveryRequestDTO) throws AndesException{
        Utils.checkToken(token);
        StoreEntity store= this.storeRepository.findById(deliveryRequestDTO.getId());
        ClientEntity client= this.clientRepository.findById(deliveryRequestDTO.getClient());
        UserEntity user= this.userRepository.findById(deliveryRequestDTO.getIdUser());
        this.deliveryRepository.insertOrder(new DeliveryPurchaseEntity(null,deliveryRequestDTO.getAmount(), StateEnum.PENDING, client, user,store, null, null, null));
        store.setAmount(store.getAmount()- deliveryRequestDTO.getAmount());
        this.storeRepository.updateStore(store);
        DataResponseDTO dataResponseDTO= new DataResponseDTO();
        dataResponseDTO.setData(ConstantErrors.ERRORS_STATES.get(AndesErrorEnum.SUCCESS_TRANSACTION.getCode()));
        return dataResponseDTO;
    }

    public DataResponseDTO executeUpdateOrder(String token, List<OrderRequestDTO> orderRequestDTO) throws AndesException{
        Utils.checkToken(token);
        for(OrderRequestDTO it : orderRequestDTO){
            DriverEntity driver = this.driverRepository.getDriverById(it.getDriver());
            OrderPurchaseEntity order = this.orderRepository.getOrderById(it.getIdOrder());
            order.setState(StateEnum.PROCESSED);
            this.deliveryRepository.insertOrder(new DeliveryPurchaseEntity(null,it.getAmount(), StateEnum.PENDING, order.getClient(), order.getUserEntity(),order.getStore(), null, driver, order));
            this.orderRepository.updateOrder(order);
        }
        DataResponseDTO dataResponseDTO= new DataResponseDTO();
        dataResponseDTO.setData(ConstantErrors.ERRORS_STATES.get(AndesErrorEnum.SUCCESS_TRANSACTION.getCode()));
        return dataResponseDTO;
    }
}