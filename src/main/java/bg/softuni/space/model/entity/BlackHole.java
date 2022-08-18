package bg.softuni.space.model.entity;


import bg.softuni.space.model.entity.enums.BlackHoleWeightEnum;

import javax.persistence.*;

@Entity
@Table(name = "black_holes")
public class BlackHole extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BlackHoleWeightEnum weight;

    @ManyToOne()
    private Galaxy galaxy;

    public BlackHole() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public BlackHoleWeightEnum getWeight() {
        return weight;
    }

    public void setWeight(BlackHoleWeightEnum weight) {
        this.weight = weight;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }


}
