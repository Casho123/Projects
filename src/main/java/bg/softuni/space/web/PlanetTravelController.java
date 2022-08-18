package bg.softuni.space.web;

import bg.softuni.space.model.dto.PickPlanetDTO;
import bg.softuni.space.model.dto.CreatePlanetDTO;
import bg.softuni.space.model.dto.PlanetDTO;
import bg.softuni.space.model.dto.ShipDTO;
import bg.softuni.space.service.PlanetService;
import bg.softuni.space.service.ShipService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PlanetTravelController {

    private final ShipService shipService;
    private final PlanetService planetService;

    public PlanetTravelController(ShipService shipService, PlanetService planetService) {
        this.shipService = shipService;
        this.planetService = planetService;
    }

    @ModelAttribute("pickPlanetDTO")
    public PickPlanetDTO initPickPlanet() {
        return new PickPlanetDTO();
    }


    @GetMapping("/pick/planet")
    public String planet(Model model) {

        List<ShipDTO> ships = this.shipService.getShips();
        List<PlanetDTO> planets = this.planetService.getPlanets();

        model.addAttribute("ships", ships);
        model.addAttribute("planets", planets);
        return "pick-planet";
    }

    @PostMapping("/pick/planet")
    public String planet(@Valid PickPlanetDTO pickPlanetDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("pickPlanetDTO", pickPlanetDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.pickPlanetDTO",
                    bindingResult);

            return "redirect:/pick/planet";
        }
        return "redirect:/travel/planet";

    }

    @GetMapping("/travel/planet")
    public String visualPlanet() {
        return "planet-visual";
    }
}
