package com.zmslabs.minet.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "otp")
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String otpCode;
    private LocalDateTime expiryTime;

    private Boolean verified;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
