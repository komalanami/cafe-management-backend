package com.ideastack.cafe_management_backend.config;

import com.ideastack.cafe_management_backend.Model.User;
import com.ideastack.cafe_management_backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class CustomerUserDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(CustomerUserDetailsService.class);

    private final UserRepository userRepository;


    public CustomerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Inside loadByUsername class {} ",email);
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getRole() != null ? user.getRole() : "USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }

}
