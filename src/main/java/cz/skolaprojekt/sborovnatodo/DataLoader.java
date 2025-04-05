package cz.skolaprojekt.sborovnatodo;

import cz.skolaprojekt.sborovnatodo.model.Role;
import cz.skolaprojekt.sborovnatodo.model.User;
import cz.skolaprojekt.sborovnatodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        userService.findByEmail("admin@skolamolekula.cz").ifPresentOrElse(
                u -> {},
                () -> {
                    User admin = User.builder()
                            .email("admin@skolamolekula.cz")
                            .jmeno("Admin")
                            .heslo(passwordEncoder.encode("admin123"))
                            .role(Role.ADMIN)
                            .aktivni(true)
                            .build();
                    userService.save(admin);
                    System.out.println("✅ Vytvořen výchozí administrátor");
                }
        );
    }
}
