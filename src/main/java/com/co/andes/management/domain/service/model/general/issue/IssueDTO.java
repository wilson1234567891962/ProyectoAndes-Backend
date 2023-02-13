package com.co.andes.management.domain.service.model.general.issue;
import com.co.andes.management.domain.service.model.request.issue.FieldIssueRequestDTO;
import java.util.List;

public class IssueDTO {
    private String id;
    private String nameRuta;
    private String name;
    private List<FieldIssueRequestDTO> fields;
    private String image;
    private List<String> comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameRuta() {
        return nameRuta;
    }

    public void setNameRuta(String nameRuta) {
        this.nameRuta = nameRuta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FieldIssueRequestDTO> getFields() {
        return fields;
    }

    public void setFields(List<FieldIssueRequestDTO> fields) {
        this.fields = fields;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }
}
