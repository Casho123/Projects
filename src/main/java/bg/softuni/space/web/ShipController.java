package bg.softuni.space.web;


import bg.softuni.space.model.dto.CreateShipDTO;
import bg.softuni.space.service.ShipService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @ModelAttribute("shipDTO")
    public CreateShipDTO initShip() {
        return new CreateShipDTO();
    }

    @GetMapping("/add/ship")
    public String addShip() {
        return "ship-add";
    }

    @PostMapping("/add/ship")
    public String addShip(@Valid CreateShipDTO shipDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipDTO", shipDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipDTO",
                    bindingResult);

            return "redirect:/add/ship";
        }
        if (!this.shipService.addShip(shipDTO)) {
            redirectAttributes.addFlashAttribute("shipDTO", shipDTO);
            redirectAttributes.addFlashAttribute("bad_ship",
                    true);

            return "redirect:/add/ship";
        }



        return "redirect:/";
    }

}
