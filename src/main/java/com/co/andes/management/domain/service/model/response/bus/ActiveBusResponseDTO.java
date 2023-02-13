package com.co.andes.management.domain.service.model.response.bus;
import com.co.andes.management.domain.service.model.response.menu.MenuResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.log4j.Logger;

import java.util.List;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActiveBusResponseDTO {

    final static Logger logger = Logger.getLogger(ActiveBusResponseDTO.class);
    private Integer idDriver;
    private String name;
    private String image;
    private Integer activeBus;
    private Integer activeDriver;
    private String position;
    private List<MenuResponseDTO> menu;

    public ActiveBusResponseDTO() {
    }
}
