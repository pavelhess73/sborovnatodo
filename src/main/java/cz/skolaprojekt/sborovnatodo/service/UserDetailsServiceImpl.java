package cz.skolaprojekt.sborovnatodo.service;

import cz.skolaprojekt.sborovnatodo.model.User;
import cz.skolaprojekt.sborovnatodo.repository.UserRepository;
import cz.skolaprojekt.sborovnatodo.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Uživatel nenalezen: " + email));
        return new UserPrincipal(user);
    }
}
