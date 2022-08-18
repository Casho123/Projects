package bg.softuni.space.web;

import bg.softuni.space.model.entity.Galaxy;
import bg.softuni.space.service.GalaxyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GalaxyController {

    private final GalaxyService galaxyService;

    public GalaxyController(GalaxyService galaxyService) {
        this.galaxyService = galaxyService;
    }

}
