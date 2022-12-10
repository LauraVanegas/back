package com.example.proyectoIntegrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol Rol;

    public AppUser(String nombre, String username, String email, String password, com.example.proyectoIntegrador.model.Rol rol) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
        Rol = rol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var grantedAuthority  = new SimpleGrantedAuthority(Rol.name());
        return Collections.singletonList(grantedAuthority);
    }
    @Override
    public String getPassword(){return password;}

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
