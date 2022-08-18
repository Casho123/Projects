package bg.softuni.space.repository;

import bg.softuni.space.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);
    Optional<Ship> findById(Long id);
}
