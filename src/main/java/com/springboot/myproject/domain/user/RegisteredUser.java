package com.springboot.myproject.domain.user;

import com.springboot.myproject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class RegisteredUser extends BaseTimeEntity {
    @Id
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public RegisteredUser(String id, String pw, String name, String email, Role role){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
