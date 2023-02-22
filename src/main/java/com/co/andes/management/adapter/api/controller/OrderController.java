package com.co.andes.management.adapter.api.controller;
import com.co.andes.management.adapter.api.ApiConst;
import com.co.andes.management.adapter.api.facade.OrderFacade;
import com.co.andes.management.domain.service.model.request.OrdersRequestDTO;
import com.co.andes.management.utils.exception.AndesErrorEnum;
import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.utils.exception.ConstantErrors;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = ApiConst.ORDER_PATH)
@CrossOrigin(origins = "*")
public class OrderController {

    final static Logger logger = Logger.getLogger(OrderController.class);

    private OrderFacade orderFacade;
    private Gson gson;

    @Autowired
    public OrderController(OrderFacade orderFacade, Gson gson) {
        this.orderFacade = orderFacade;
        this.gson = gson;
    }

	@ApiOperation(value = "getOrder")
	@RequestMapping(value = "/getOrder/", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getOrder(@RequestHeader(value="Authorization") String token) {
		try {
			return new ResponseEntity<String>(this.gson.toJson(this.orderFacade.executeGetOrder(token)), HttpStatus.OK);
		}
		catch (AndesException e) {
			e.printStackTrace();
			logger.error("Se presentaron problemas en el controller login ", e);
			return new ResponseEntity<String>(new Gson().toJson(ConstantErrors.ERRORS_STATES.get(e.getMessage())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch (Exception e) {
			logger.error("Se presentaron problemas enviar la checkFields en el controller login",e);
			return new ResponseEntity<String> (this.gson.toJson(ConstantErrors.ERRORS_STATES.get(AndesErrorEnum.GENERIC_ERROR.getCode())), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
