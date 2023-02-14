package com.co.andes.management.adapter.api.facade;
import com.co.andes.management.domain.service.model.request.LoginRequestDTO;
import com.co.andes.management.domain.service.model.request.PasswordRequestDTO;
import com.co.andes.management.domain.service.model.request.RegisterRequestDTO;
import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.domain.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;

@Service
public class LoginFacade {


    final static Logger logger = Logger.getLogger(LoginFacade.class);
    
    private LoginService loginService;
    
    @Autowired
    public LoginFacade(LoginService generalService) {
    	this.loginService = generalService;
    }
    
    public Object executeLogin(LoginRequestDTO loginRequestDTO) throws AndesException, ExecutionException, InterruptedException{
        return  this.loginService.executeValidation(loginRequestDTO);
    }

    public Object executeRegister(RegisterRequestDTO registerRequestDTO) throws AndesException, ExecutionException, InterruptedException{
        return  this.loginService.executeRegister(registerRequestDTO);
    }

    @Async
    public void executeForgetPassword(PasswordRequestDTO passwordRequestDTO){
        this.loginService.executeEmail(passwordRequestDTO);
    }
}
