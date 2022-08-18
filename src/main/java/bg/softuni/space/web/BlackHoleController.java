package bg.softuni.space.web;

import bg.softuni.space.model.dto.CreateBlackHoleDTO;
import bg.softuni.space.service.BlackHoleService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BlackHoleController {

    private final BlackHoleService blackHoleService;

    public BlackHoleController(BlackHoleService blackHoleService) {
        this.blackHoleService = blackHoleService;
    }


    @ModelAttribute("blackHoleDTO")
    public CreateBlackHoleDTO initBlackHole() {
        return new CreateBlackHoleDTO();
    }

    @GetMapping("/add/blackhole")
    public String blackHole() {
        return "blackhole-add";
    }

    @PostMapping("/add/blackhole")
    public String blackHole(@Valid CreateBlackHoleDTO blackHoleDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !this.blackHoleService.save(blackHoleDTO)) {
            redirectAttributes.addFlashAttribute("blackHoleDTO", blackHoleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.blackHoleDTO",
                    bindingResult);

            return "redirect:/add/blackhole";
        }

        return "redirect:/";
    }


}
