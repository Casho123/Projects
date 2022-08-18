package bg.softuni.space.model.dto;

import javax.validation.constraints.Positive;

public class PickPlanetDTO {

    @Positive
    private int shipId;

    @Positive
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
