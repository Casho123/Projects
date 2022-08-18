package bg.softuni.space.model.dto;

import bg.softuni.space.model.entity.Planet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreatePlanetDTO {
    @NotBlank(message = "Name must not be empty.")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols.")
    private String name;
    @NotNull
    @Positive(message = "Age must be positive.")
    private long age;
    @NotNull
    @Positive(message = "Temperature must be positive.")
    private long temperature;
    @NotBlank(message = "Galaxy cannot be empty.")
    private String galaxy;

    public CreatePlanetDTO() {
    }
    public CreatePlanetDTO(Planet planet) {
        this.name = planet.getName();
        this.age = planet.getAge();
        this.temperature = planet.getTemperature();
        this.galaxy = planet.getGalaxy().getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }
}
