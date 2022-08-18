package bg.softuni.space.service;

import bg.softuni.space.model.dto.CreatePlanetDTO;
import bg.softuni.space.model.dto.PlanetDTO;
import bg.softuni.space.model.entity.Galaxy;
import bg.softuni.space.model.entity.Planet;
import bg.softuni.space.repository.PlanetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;
    private final ModelMapper modelMapper;
    private final GalaxyService galaxyService;

    public PlanetService(PlanetRepository planetRepository, ModelMapper modelMapper, GalaxyService galaxyService) {
        this.planetRepository = planetRepository;
        this.modelMapper = modelMapper;
        this.galaxyService = galaxyService;
    }


    public boolean save(CreatePlanetDTO planetDTO) {
        Optional<Planet> byName = this.planetRepository.findByName(planetDTO.getName());
        if (byName.isPresent()) {
            return false;
        }
        Galaxy galaxy = this.galaxyService.findGalaxyId(planetDTO.getGalaxy());
        Planet planet = modelMapper.map(planetDTO, Planet.class);
        planet.setGalaxy(galaxy);

        this.planetRepository.save(planet);
        return true;
    }

    public List<PlanetDTO> getPlanets() {
        return this.planetRepository.findAll().stream()
                .map(PlanetDTO::new)
                .collect(Collectors.toList());
    }
}
