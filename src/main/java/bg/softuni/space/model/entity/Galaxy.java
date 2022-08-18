package bg.softuni.space.model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "galaxies")
public class Galaxy extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, name = "length_in_light_years")
    private Long lengthInLightYears;

    @Column(nullable = false)
    private Long age;


    public Galaxy() {

    }

    public Galaxy(String name, Long lengthInLightYears, Long age) {
        this.name = name;
        this.lengthInLightYears = lengthInLightYears;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLengthInLightYears() {
        return lengthInLightYears;
    }

    public void setLengthInLightYears(Long lengthInLightYears) {
        this.lengthInLightYears = lengthInLightYears;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

}
