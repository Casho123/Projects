package bg.softuni.space.service;

import bg.softuni.space.model.entity.Galaxy;
import bg.softuni.space.repository.GalaxyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GalaxyService {

    private final GalaxyRepository galaxyRepository;

    public GalaxyService(GalaxyRepository galaxyRepository) {
        this.galaxyRepository = galaxyRepository;
    }

    public void initGalaxies()  {
        if(this.galaxyRepository.count() == 0) {
            Galaxy andromeda = new Galaxy("Andromeda",150000L, 700000000L);
            Galaxy ngc = new Galaxy("NGC-1300",100000L, 600000000L);
            Galaxy sauron = new Galaxy("Eye Of Sauron",70000L, 15000000L);
            Galaxy malin = new Galaxy("Malin-1",50000L, 15000000L);




            this.galaxyRepository.save(andromeda);
            this.galaxyRepository.save(ngc);
            this.galaxyRepository.save(sauron);
            this.galaxyRepository.save(malin);
        }
    }


    public Galaxy findGalaxyId(String name) {
        return this.galaxyRepository.findByName(name);

    }
}
