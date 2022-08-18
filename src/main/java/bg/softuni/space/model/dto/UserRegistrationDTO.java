package bg.softuni.space.model.dto;

import javax.validation.constraints.*;

public class UserRegistrationDTO {
    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols.")
    private String name;
    @NotBlank(message = "Username cannot be empty.")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 symbols.")
    private String username;
    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email must be valid.")
    private String email;
    @NotNull(message = "Age must not be empty.")
    @Positive(message = "Age must be more than 0.")
    private int age;
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 5, max = 20, message = "Password must be between 5 and 20 symbols.")
    private String password;
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 5, max = 20, message = "Password must be between 5 and 20 symbols.")
    private String confirmPassword;

    public UserRegistrationDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
