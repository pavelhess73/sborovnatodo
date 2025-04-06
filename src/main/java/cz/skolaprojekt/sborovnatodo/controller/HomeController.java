package cz.skolaprojekt.sborovnatodo.controller;

import cz.skolaprojekt.sborovnatodo.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserPrincipal userPrincipal, Model model) {
        model.addAttribute("jmeno", userPrincipal.getUser().getJmeno());
        return "dashboard";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
