package bt.edu.gcit.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;

@Service
public class AuthServiceImpl implements AuthService {
    // @Autowired
    // private AuthenticationManager authenticationManager;
    // @Autowired
    // private UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Autowired
    public AuthServiceImpl(@Lazy AuthenticationManager authenticationManager,
            @Lazy UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public UserDetails login(String email, String password) {
        // System.out.println("show: " + authenticationManager.authenticate(new
        // UsernamePasswordAuthenticationToken(email, password)));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        return userDetailsService.loadUserByUsername(email);
    }
}
