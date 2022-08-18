package bg.softuni.space.repository;

import bg.softuni.space.model.entity.BlackHole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlackHoleRepository extends JpaRepository<BlackHole, Long> {

    Optional<BlackHole> findByName(String name);
}
