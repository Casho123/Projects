package bg.softuni.space.web;


import bg.softuni.space.model.dto.*;
import bg.softuni.space.service.BlackHoleService;
import bg.softuni.space.service.ShipService;
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
public class BlackHoleTravelController {

    @ModelAttribute("pickBlackHoleDTO")
    public PickBlackHoleDTO initPickBlackHole() {
        return new PickBlackHoleDTO();
    }

    private final ShipService shipService;
    private final BlackHoleService blackHoleService;

    public BlackHoleTravelController(ShipService shipService, BlackHoleService blackHoleService) {
        this.shipService = shipService;
        this.blackHoleService = blackHoleService;
    }


    @GetMapping("/pick/blackhole")
    public String planet(Model model) {

        List<ShipDTO> ships = this.shipService.getShips();
        List<BlackHoleDTO> blackHoles = this.blackHoleService.getBlackHoles();

        model.addAttribute("ships", ships);
        model.addAttribute("blackHoles", blackHoles);
        return "pick-bh";
    }

    @PostMapping("/pick/blackhole")
    public String blackHole(@Valid PickBlackHoleDTO pickBlackHoleDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("pickBlackHoleDTO", pickBlackHoleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.pickBlackHoleDTO",
                    bindingResult);

            return "redirect:/pick/blackhole";
        }
        this.shipService.destroyShip(pickBlackHoleDTO.getShipId());
        return "redirect:/travel/blackhole";

    }

    @GetMapping("/travel/blackhole")
    public String blackHoleVisual() {
        return "blackhole-visual";
    }
}
