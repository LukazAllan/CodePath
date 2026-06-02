package br.com.codepath.api.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "session")
@Entity
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(name = "ip_addr")
    private String ipAddress;

    @Column(nullable = false)
    private LocalDateTime createdAt =  LocalDateTime.now();

    @Column(name = "last_activity", nullable = false)
    private LocalDateTime lastActivity;

    @Column(name = "platform")
    private String platform;
    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "language")
    private String language;

    @Column(name = "resolution")
    private String resolution;

}
