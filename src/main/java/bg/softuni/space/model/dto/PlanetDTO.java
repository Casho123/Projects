package bg.softuni.space.model.dto;

import bg.softuni.space.model.entity.Planet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PlanetDTO {

    private long id;

    private String name;

    private long age;

    private long temperature;

    private String galaxy;

    public PlanetDTO() {
    }

    public PlanetDTO(Planet planet) {
        this.id = planet.getId();
        this.name = planet.getName();
        this.age = planet.getAge();
        this.temperature = planet.getTemperature();
        this.galaxy = planet.getGalaxy().getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
