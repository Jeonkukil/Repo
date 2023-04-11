package shop.mtcoding.securityapp.core.auth;

import java.util.Optional;
import shop.mtcoding.securityapp.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.securityapp.model.UserRepository;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

private final UserRepository userRepository;
// login + post FormUrlEncoded + username, password
// Authentication 객체 만들어짐
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOP = userRepository.findByUsername(username);
        if(userOP.isPresent()) {
            return new MyUserDetails(userOP.get());
        }
        return null;
        }
    
}
