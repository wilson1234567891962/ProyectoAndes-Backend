package com.co.andes.management.utils.timer;
import com.co.andes.management.adapter.api.ApiConst;
import com.co.andes.management.domain.repository.EmailRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ScheduledTasks {

    RestTemplate restTemplate;
    final static Logger logger = Logger.getLogger(ScheduledTasks.class);

    @Autowired
    public ScheduledTasks(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
    @Scheduled(fixedRate = 15000)
    public void checkService() {
        try {
            String message = restTemplate.getForObject(
                    ApiConst.URL_SERVICE, String.class);
            if(!message.equals("V20200914_01"))  {
                logger.error("El servicio se encuentra con problemas tecnicos con el servicio  "+  ApiConst.URL_SERVICE);
            } else  {
                logger.info("No se han presentando problemas con el servicio  "+  ApiConst.URL_SERVICE);
            }
        }catch (Exception e) {
            logger.error("El servicio se encuentra con problemas tecnicos con el servicio  "+  ApiConst.URL_SERVICE);
        }


    }
    **/
}