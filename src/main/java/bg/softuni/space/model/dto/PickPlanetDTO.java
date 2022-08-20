package bg.softuni.space.model.dto;

import javax.validation.constraints.Positive;

public class PickPlanetDTO {

    @Positive(message = "You must choose a ship.")
    private int shipId;

    @Positive(message = "You must choose a planet.")
    private int planetId;

    public PickPlanetDTO() {
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public int getPlanetId() {
        return planetId;
    }

    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }
}
