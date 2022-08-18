package bg.softuni.space.model.entity;

import bg.softuni.space.model.entity.enums.ShipModelEnum;

import javax.persistence.*;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int speedInLightYears;

    @Column(nullable = false)
    private int length;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "ship_model")
    private ShipModelEnum shipModel;

    public Ship() {
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

    public ShipModelEnum getShipModel() {
        return shipModel;
    }

    public void setShipModel(ShipModelEnum shipModel) {
        this.shipModel = shipModel;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
