package bg.softuni.space.service.init;


import bg.softuni.space.service.GalaxyService;
import bg.softuni.space.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {


    private final UserService userService;
    private final GalaxyService galaxyService;

    public DataInit(UserService userService, GalaxyService galaxyService) {
        this.userService = userService;
        this.galaxyService = galaxyService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.galaxyService.initGalaxies();
        this.userService.initUserRoles();
        this.userService.initAdmin();

    }
}
