package com.co.andes.management.domain.service;
import com.co.andes.management.adapter.email.model.request.EmailEMRequestDTO;
import com.co.andes.management.domain.repository.AuditRepository;
import com.co.andes.management.domain.repository.EmailRepository;
import com.co.andes.management.domain.repository.UserRepository;
import com.co.andes.management.domain.repository.model.database.AuditEntity;
import com.co.andes.management.domain.repository.model.database.UserEntity;
import com.co.andes.management.domain.repository.model.database.enums.EventEnum;
import com.co.andes.management.domain.service.model.request.LoginRequestDTO;
import com.co.andes.management.domain.service.model.request.PasswordRequestDTO;
import com.co.andes.management.domain.service.model.request.RegisterRequestDTO;
import com.co.andes.management.domain.service.model.response.DataResponseDTO;
import com.co.andes.management.domain.service.model.response.login.LoginResponseDTO;
import com.co.andes.management.utils.exception.AndesErrorEnum;
import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.utils.exception.ConstantErrors;
import com.co.andes.management.utils.token.JwtUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LoginService {

    final static Logger logger = Logger.getLogger(LoginService.class);
    private UserRepository userRepository;
    private AuditRepository auditRepository;
    private EmailRepository emailRepository;

    @Autowired
    public LoginService(UserRepository userRepository, AuditRepository auditRepository, EmailRepository emailRepository) {
        this.auditRepository = auditRepository;
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
    }

    public DataResponseDTO executeValidation(LoginRequestDTO loginRequestDTO) throws AndesException{
        Optional<UserEntity> user = userRepository.getUserByPasswordAndUser(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        if (user.isPresent() && user.get().getIsActive() == 0 ) {
            throw new AndesException(AndesErrorEnum.LOGIN_PASSWORD_AND_USER_IS_NOT_ACTIVE.getCode());
        }
        if (user.isPresent()) {
            String token = JwtUtils.createJWT(loginRequestDTO.getEmail(), loginRequestDTO.getPassword(), loginRequestDTO.getEmail(),300000);
            AuditEntity audit = this.auditRepository.sendRegisterEvent( token, EventEnum.LOGIN_USER, new Date());
            user.get().getAudit().add(audit);
            userRepository.updateUser(user.get());
            return new DataResponseDTO(new LoginResponseDTO(token, user.get().getId().toString(), user.get().getRol().getRol().getRol()));
        }
        this.auditRepository.sendRegisterEvent("", EventEnum.TRY_TO_LOGIN_WITH_WRONG_EMAIL_AND_PASSWORD, new Date());
        throw new AndesException(AndesErrorEnum.LOGIN_PASSWORD_AND_USER_CONSULTING.getCode());
    }

    public DataResponseDTO executeRegister(RegisterRequestDTO registerRequestDTO) throws AndesException{
        if(registerRequestDTO.getEmail().isEmpty() ||  registerRequestDTO.getPassword().isEmpty()){
            throw new AndesException(AndesErrorEnum.REGISTER_PASSWORD_AND_USER_CONSULTING.getCode());
        }

        Optional<UserEntity> user = userRepository.getUserByEmail(registerRequestDTO.getEmail());

        if (!user.isPresent()) {
            AuditEntity au = this.auditRepository.sendRegisterEvent( "", EventEnum.REGISTER_USER, new Date());
            List<AuditEntity> listAu = new ArrayList<>();
            listAu.add(au);
            userRepository.saveUser(registerRequestDTO.getEmail(), registerRequestDTO.getPassword(), 0, listAu);

            DataResponseDTO dataResponseDTO= new DataResponseDTO();
            dataResponseDTO.setData(ConstantErrors.ERRORS_STATES.get(AndesErrorEnum.SUCCESS_TRANSACTION.getCode()));
            return dataResponseDTO;
        }
        throw new AndesException(AndesErrorEnum.REGISTER_PASSWORD_AND_USER_CONSULTING.getCode());
    }

    public void executeEmail(PasswordRequestDTO passwordRequestDTO) {
        try {
            Optional<UserEntity> user = userRepository.getUserByEmail(passwordRequestDTO.getEmail());
            if (user.isPresent() ) {
                AuditEntity audit = this.auditRepository.sendRegisterEvent("", EventEnum.EMAIL_FORGET, new Date());
                user.get().getAudit().add(audit);
                userRepository.updateUser(user.get());
                EmailEMRequestDTO emailEMRequestDTO = new EmailEMRequestDTO(user.get().getEmail(), user.get().getPassword());
                this.emailRepository.sendEmail(emailEMRequestDTO);
                return;
            }
        } catch (Exception e) {
            logger.error("Se presentaron para ejecutar el services executeEmail", e);
        }
    }


}