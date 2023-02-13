package com.co.andes.management.domain.service.model.response.alert;

import java.util.List;

public class AlertDTO {
    private List<AlertTitleDTO> alertTitles;
    private List<ContentAlertDTO> content;

    public List<AlertTitleDTO> getAlertTitles() {
        return alertTitles;
    }

    public void setAlertTitles(List<AlertTitleDTO> alertTitles) {
        this.alertTitles = alertTitles;
    }

    public List<ContentAlertDTO> getContent() {
        return content;
    }

    public void setContent(List<ContentAlertDTO> content) {
        this.content = content;
    }
}
