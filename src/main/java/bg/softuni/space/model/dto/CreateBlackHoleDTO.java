package bg.softuni.space.model.dto;

import bg.softuni.space.model.entity.enums.BlackHoleWeightEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreateBlackHoleDTO {
    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols.")
    private String name;
    @NotNull(message = "Age cannot be empty")
    @Positive(message = "Age must be more than 0.")
    private long age;
    @NotNull(message = "Weight cannot be empty.")
    private BlackHoleWeightEnum weight;
    @NotBlank(message = "Galaxy cannot be empty")
    private String galaxy;

    public CreateBlackHoleDTO() {
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

    public BlackHoleWeightEnum getWeight() {
        return weight;
    }

    public void setWeight(BlackHoleWeightEnum weight) {
        this.weight = weight;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }
}
