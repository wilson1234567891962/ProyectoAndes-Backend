package com.co.andes.management.domain.service.model.general.issue;

import java.util.List;

public class IncidentDTO {
    private List<IssueDTO> reports;

    public List<IssueDTO> getReports() {
        return reports;
    }

    public void setReport(List<IssueDTO> reports) {
        this.reports = reports;
    }
}
