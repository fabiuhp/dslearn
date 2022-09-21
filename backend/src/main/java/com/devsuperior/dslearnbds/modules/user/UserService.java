package com.devsuperior.dslearnbds.modules.user;

import com.devsuperior.dslearnbds.config.AuthService;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        authService.validateSelfOrAdmin(id);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new UserDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            logger.error("Usuario não encontrado: " + username);
            throw new UsernameNotFoundException("Email não encontrado");
        }

        logger.info("Usuario encontrado: " + username);
        return user;
    }
}
