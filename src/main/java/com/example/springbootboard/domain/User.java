package com.example.springbootboard.domain;

import com.example.springbootboard.constant.Authority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "user")
    private List<PortFolio> portFolios = new ArrayList<>();


    public User(String subject, String s, Collection<? extends GrantedAuthority> authorities) {
    }
}
