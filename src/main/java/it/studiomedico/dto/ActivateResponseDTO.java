package it.studiomedico.dto;

public class ActivateResponseDTO extends BaseResponse{
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String username) {
        this.firstName = username;
    }
}
