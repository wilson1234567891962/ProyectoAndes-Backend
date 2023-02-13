package com.co.andes.management.domain.service.model.general.alerts;

public enum  ActionsAlert {
 SOAT("SOAT"),
 TECNO("TECNO"),
 LICENSE("LICEN");

 private String action;

 ActionsAlert(String act) {
  this.action = act;
 }

 public String getAction() {
  return action;
 }
}
