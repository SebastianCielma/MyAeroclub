package pl.sebastiancielma.MyAeroclub.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sebastiancielma.MyAeroclub.security.model.AirplaneforsaleUserDetails;
import pl.sebastiancielma.MyAeroclub.security.model.User;
import pl.sebastiancielma.MyAeroclub.security.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AirplaneforsaleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(Long.parseLong(username)).orElseThrow();
        AirplaneforsaleUserDetails airplaneforsaleUserDetails = new AirplaneforsaleUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities().stream()
                        .map(userRole -> (GrantedAuthority) () -> userRole.name())
                        .toList()
        );
        airplaneforsaleUserDetails.setId(user.getId());
        return airplaneforsaleUserDetails;
    }
}
