package bg.softuni.space.service;

import bg.softuni.space.model.dto.BlackHoleDTO;
import bg.softuni.space.model.dto.CreateBlackHoleDTO;
import bg.softuni.space.model.dto.PlanetDTO;
import bg.softuni.space.model.entity.BlackHole;
import bg.softuni.space.model.entity.Galaxy;
import bg.softuni.space.repository.BlackHoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlackHoleService {

    private final ModelMapper modelMapper;
    private final BlackHoleRepository blackHoleRepository;
    private final GalaxyService galaxyService;

    public BlackHoleService(ModelMapper modelMapper, BlackHoleRepository blackHoleRepository, GalaxyService galaxyService) {
        this.modelMapper = modelMapper;
        this.blackHoleRepository = blackHoleRepository;
        this.galaxyService = galaxyService;
    }


    public boolean save(CreateBlackHoleDTO blackHoleDTO) {
        Optional<BlackHole> byName = this.blackHoleRepository.findByName(blackHoleDTO.getName());
        if (byName.isPresent()) {
            return false;
        }
        Galaxy galaxy = this.galaxyService.findGalaxyId(blackHoleDTO.getGalaxy());
        BlackHole blackHole = modelMapper.map(blackHoleDTO, BlackHole.class);
        blackHole.setGalaxy(galaxy);

        this.blackHoleRepository.save(blackHole);
        return true;
    }

    public List<BlackHoleDTO> getBlackHoles() {
        return this.blackHoleRepository.findAll().stream()
                .map(BlackHoleDTO::new)
                .collect(Collectors.toList());
    }
}
