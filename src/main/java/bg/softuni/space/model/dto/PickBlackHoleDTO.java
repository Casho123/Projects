package bg.softuni.space.model.dto;

import javax.validation.constraints.Positive;

public class PickBlackHoleDTO {

    @Positive(message = "You must choose a ship.")
    private Long shipId;

    @Positive(message = "You must choose a black hole.")
    private Long blackHoleId;

    public PickBlackHoleDTO() {
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getBlackHoleId() {
        return blackHoleId;
    }

    public void setBlackHoleId(Long blackHoleId) {
        this.blackHoleId = blackHoleId;
    }
}
