package com.SpringBoot_PollingApp_Assignment.api.services.auth;

import com.SpringBoot_PollingApp_Assignment.api.models.Role;
import com.SpringBoot_PollingApp_Assignment.api.models.User;
import com.SpringBoot_PollingApp_Assignment.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {
    @Autowired

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNom(username).orElseThrow();
        return new org.springframework.security.core.userdetails.User(user.getNom(), user.getMotDePasse(), mapRolesToAuthority(user.getRoles())) {
        };

    }

    private Collection<GrantedAuthority> mapRolesToAuthority(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
