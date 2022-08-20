package bg.softuni.space.web;

import bg.softuni.space.model.dto.CreatePlanetDTO;
import bg.softuni.space.service.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }


    @ModelAttribute("planetDTO")
    public CreatePlanetDTO initPlanet() {
        return new CreatePlanetDTO();
    }

    @GetMapping("/add/planet")
    public String planet() {
        return "planet-add";
    }

    @PostMapping("/add/planet")
    public String planet(@Valid CreatePlanetDTO planetDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("planetDTO", planetDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.planetDTO",
                    bindingResult);

            return "redirect:/add/planet";
        }
        if (!this.planetService.save(planetDTO)) {
            redirectAttributes.addFlashAttribute("planetDTO", planetDTO);
            redirectAttributes.addFlashAttribute("bad_name_planet",
                    true);

            return "redirect:/add/planet";
        }

        return "redirect:/";
    }


}
