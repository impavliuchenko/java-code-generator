package com.codegen.entities;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "`user`")
public class User implements UserDetails{

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String username; //email
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String nickName;
    private Date dateBirthday;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> authorities;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set <Diagram> diagrams;

}
