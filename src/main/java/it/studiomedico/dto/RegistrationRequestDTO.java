package it.studiomedico.dto;

public class RegistrationRequestDTO extends UserDTO{
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
