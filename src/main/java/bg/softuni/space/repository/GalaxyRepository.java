package bg.softuni.space.repository;

import bg.softuni.space.model.entity.Galaxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalaxyRepository extends JpaRepository<Galaxy, Long> {

    Galaxy findByName(String name);

}
