package cz.skolaprojekt.sborovnatodo.controller;

import cz.skolaprojekt.sborovnatodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String seznamUzivatelu(Model model) {
        model.addAttribute("uzivatele", userService.findAll());
        return "users";
    }
}
