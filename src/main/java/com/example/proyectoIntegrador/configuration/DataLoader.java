package com.example.proyectoIntegrador.configuration;

import com.example.proyectoIntegrador.model.AppUser;
import com.example.proyectoIntegrador.model.AppUsuarioRoles;
import com.example.proyectoIntegrador.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass= passwordEncoder.encode("contraseña");

        userRepository.save(new AppUser(null,"Raul","Raul","raul@gmail.com",pass,AppUsuarioRoles.ROLE_USER));
    }
}
