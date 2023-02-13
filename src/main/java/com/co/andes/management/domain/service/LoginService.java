package com.co.andes.management.domain.service;
import com.co.andes.management.domain.repository.EmailRepository;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import com.co.andes.management.domain.service.model.request.LoginRequestDTO;
import com.co.andes.management.domain.service.model.response.DataResponseDTO;
import com.co.andes.management.domain.service.model.response.LoginResponseDTO;
import com.co.andes.management.utils.exception.UMBErrorEnum;
import com.co.andes.management.utils.exception.UMBException;
import com.co.andes.management.utils.token.JwtUtils;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class LoginService {

    final static Logger logger = Logger.getLogger(LoginService.class);
    private UserRepository userRepository;
    private DozerBeanMapper dozerBeanMapper;
    private EmailRepository emailRepository;

    @Autowired
    public LoginService(UserRepository userRepository, DozerBeanMapper dozerBeanMapper, EmailRepository emailRepository) {
        this.dozerBeanMapper = dozerBeanMapper;
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
    }

    public DataResponseDTO executeValidation(LoginRequestDTO loginRequestDTO) throws UMBException , ExecutionException, InterruptedException{
        Optional<UserEntity> user = userRepository.getUserByPasswordAndUser(loginRequestDTO.getUser(), loginRequestDTO.getPassword());

        if (user.get() != null) {
            String token = JwtUtils.createJWT(loginRequestDTO.getUser(), loginRequestDTO.getPassword(), 300000);
            return new DataResponseDTO(new LoginResponseDTO(token, user.get().getId().toString(), "1"));
        }
        throw new UMBException(UMBErrorEnum.LOGIN_PASSWORD_AND_USER_CONSULTING.getCode());
    }

}