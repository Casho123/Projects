package bg.softuni.space.model.dto;

import javax.validation.constraints.*;

public class UpdateUsernameDTO {

    @NotBlank(message = "New username cannot be empty.")
    @Size(min = 3, max = 20, message = "New username must be between 3 and 20 symbols.")
    private String username;
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 5, max = 20, message = "Password must be between 5 and 20 symbols.")
    private String confirmPassword;

    public UpdateUsernameDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
