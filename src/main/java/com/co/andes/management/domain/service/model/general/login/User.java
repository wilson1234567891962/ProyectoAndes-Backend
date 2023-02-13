package com.co.andes.management.domain.service.model.general.login;

public class User {
    private String id;
    private String correo;
    private String clave;
    private String rol;
    private String lastName;
    private String firstName;

    public User(String id, String correo, String clave, String rol, String lastName, String firstName) {
        this.id = id;
        this.correo = correo;
        this.clave = clave;
        this.rol = rol;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public User() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
