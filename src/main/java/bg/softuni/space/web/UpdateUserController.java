package bg.softuni.space.web;

import bg.softuni.space.model.dto.UpdateUsernameDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UpdateUserController {

    @ModelAttribute("updateUsernameDTO")
    public UpdateUsernameDTO initUpdateUsername() {
        return new UpdateUsernameDTO();
    }

    @GetMapping("/update/username")
    public String update() {

        return "update-username";

    }
}
