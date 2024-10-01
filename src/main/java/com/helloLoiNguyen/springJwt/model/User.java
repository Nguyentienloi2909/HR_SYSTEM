package com.helloLoiNguyen.springJwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name="roleId", unique = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "departmentId", unique = false)
    private Department department;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Token> tokens;

    @OneToMany(mappedBy = "user")
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Salary> salaries;

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleName()));
    }
}
