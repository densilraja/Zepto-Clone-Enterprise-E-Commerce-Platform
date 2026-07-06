package com.zepto.user.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zepto.cart.entity.Cart;
import com.zepto.user.entity.UserRole;
// import com.zepto.order.entity.Order;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phone;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Builder.Default
    private Boolean enabled = true;

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Cart cart;

    // @OneToMany(mappedBy = "user",
    //         cascade = CascadeType.ALL)
    // @Builder.Default
    // private List<Order> orders = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}