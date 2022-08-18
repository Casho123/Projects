package bg.softuni.space.service;

import bg.softuni.space.model.dto.CreateShipDTO;
import bg.softuni.space.model.dto.ShipDTO;
import bg.softuni.space.model.entity.Ship;
import bg.softuni.space.repository.ShipRepository;
import bg.softuni.space.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {

    private final ShipRepository shipRepository;

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ShipService(ShipRepository shipRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.shipRepository = shipRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public boolean addShip(CreateShipDTO shipDTO, UserDetails userDetails) {

        Optional<Ship> byName = this.shipRepository.findByName(shipDTO.getName());
        if (byName.isPresent()) {
            return false;
        }

        Ship ship = modelMapper.map(shipDTO, Ship.class);


        this.shipRepository.save(ship);


        return true;

    }

    public List<ShipDTO> getShips() {

        return this.shipRepository.findAll().stream().map(ShipDTO::new)
                .collect(Collectors.toList());

    }

    public void destroyShip(Long id) {
        Ship foundShip = this.shipRepository.findById(id).orElseThrow();
        this.shipRepository.delete(foundShip);
    }

}
