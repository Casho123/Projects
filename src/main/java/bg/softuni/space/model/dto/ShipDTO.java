package bg.softuni.space.model.dto;

import bg.softuni.space.model.entity.Ship;
import bg.softuni.space.model.entity.enums.ShipModelEnum;

public class ShipDTO {

    private long id;
    private String name;
    private int speedInLightYears;
    private int length;
    private ShipModelEnum shipModel;

    public ShipDTO() {
    }

    public ShipDTO(Ship ship) {
        this.id = ship.getId();
        this.name = ship.getName();
        this.speedInLightYears = ship.getSpeedInLightYears();
        this.length = ship.getLength();
        this.shipModel = ship.getShipModel();
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
