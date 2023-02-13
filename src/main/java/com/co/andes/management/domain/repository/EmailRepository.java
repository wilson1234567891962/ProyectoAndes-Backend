package com.co.andes.management.domain.repository;

import com.co.andes.management.adapter.email.model.request.EmailEMRequestDTO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public interface EmailRepository {

	final static Logger logger = Logger.getLogger(EmailRepository.class);

	void sendEmail(EmailEMRequestDTO emailEMRequestDTO) throws MessagingException;

}
