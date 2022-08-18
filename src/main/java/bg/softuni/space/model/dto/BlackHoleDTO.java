package bg.softuni.space.model.dto;

import bg.softuni.space.model.entity.BlackHole;
import bg.softuni.space.model.entity.enums.BlackHoleWeightEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BlackHoleDTO {

    private long id;

    private String name;

    private long age;

    private BlackHoleWeightEnum weight;

    private String galaxy;

    public BlackHoleDTO() {
    }

    public BlackHoleDTO(BlackHole blackHole) {
        this.id = blackHole.getId();
        this.name = blackHole.getName();
        this.age = blackHole.getAge();;
        this.weight = blackHole.getWeight();
        this.galaxy = blackHole.getGalaxy().getName();

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
