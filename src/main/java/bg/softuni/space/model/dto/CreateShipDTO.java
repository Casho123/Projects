package bg.softuni.space.model.dto;

import bg.softuni.space.model.entity.Ship;
import bg.softuni.space.model.entity.enums.ShipModelEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreateShipDTO {

    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols.")
    private String name;
    @NotNull
    @Positive(message = "Speed must be positive.")
    private int speedInLightYears;
    @NotNull
    @Positive(message = "Length must be positive.")
    private int length;
    @NotNull(message = "Ship model cannot be empty.")
    private ShipModelEnum shipModel;


    public CreateShipDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeedInLightYears() {
        return speedInLightYears;
    }

    public void setSpeedInLightYears(int speedInLightYears) {
        this.speedInLightYears = speedInLightYears;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ShipModelEnum getShipModel() {
        return shipModel;
    }

    public void setShipModel(ShipModelEnum shipModel) {
        this.shipModel = shipModel;
    }
}
