package com.co.andes.management.domain.service.model.request.issue;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IssueRequestDTO {
    private String id;
    private String nameRuta;
    private String name;
    private List<FieldIssueRequestDTO> fields;
    private String image;
    private List<String> comment;
}
