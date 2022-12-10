package com.example.proyectoIntegrador.configuration;

import com.example.proyectoIntegrador.model.AppUser;
import com.example.proyectoIntegrador.model.Rol;
import com.example.proyectoIntegrador.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passAdmin = passwordEncoder.encode("contraseña");
        String passUser = passwordEncoder.encode("contraseña1");

        userRepository.save(new AppUser("carolina", "carolina", "carolina@gmail.com", passUser, Rol.ROLE_USER));
        userRepository.save(new AppUser("estefania", "estefania", "estefania@gmail.com", passAdmin, Rol.ROLE_ADMIN));

    }}
