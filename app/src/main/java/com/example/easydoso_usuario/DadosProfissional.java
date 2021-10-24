package com.example.easydoso_usuario;

public class DadosProfissional {

    // {phone=7654768, location_latitude=37.421998333333335, cpf=56546645, fullName=khalil, services=Taxi, location_longitude=-122.084,
    // birthDate=12/10/2020, email=khalil@gmail.com}

    private String phone;
    private String location_latitude;
    private String cpf;
    private String fullName;
    private String services;
    private String location_longitude;
    private String birthDate;
    private String email;
    private String imageName;

    public DadosProfissional(String phone, String location_latitude, String cpf, String fullName, String services, String location_longitude, String birthDate, String email, String imageName) {
        this.phone = phone;
        this.location_latitude = location_latitude;
        this.cpf = cpf;
        this.fullName = fullName;
        this.services = services;
        this.location_longitude = location_longitude;
        this.birthDate = birthDate;
        this.email = email;
        this.imageName = imageName;
    }
    public DadosProfissional(){}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation_latitude() {
        return location_latitude;
    }

    public void setLocation_latitude(String location_latitude) {
        this.location_latitude = location_latitude;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getLocation_longitude() {
        return location_longitude;
    }

    public void setLocation_longitude(String location_longitude) {
        this.location_longitude = location_longitude;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageName(){return imageName;}

    public void setImageName(String imageName){this.imageName = imageName;}
}
