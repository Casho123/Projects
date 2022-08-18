package bg.softuni.space.model.entity;

import bg.softuni.space.model.entity.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole  extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "user_role")
    private UserRoleEnum userRole;

    public UserRole() {
    }

    public UserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }
}
