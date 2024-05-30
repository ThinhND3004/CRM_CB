package com.cybersoft.crm.dto;

public class UserDTO {
    private String email;
    private String fullName;
    private String password;
    private String avt;

    public UserDTO(String email, String fullName, String password, String avt) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;

        this.avt = avt;
    }

    public UserDTO(String email, String fullName, String password) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.avt = "";
    }

    public UserDTO() {
        this.email = "";
        this.fullName = "";
        this.password = "";
        this.avt = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }
}
