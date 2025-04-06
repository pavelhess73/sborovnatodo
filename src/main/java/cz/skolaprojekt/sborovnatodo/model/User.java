package cz.skolaprojekt.sborovnatodo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String jmeno;

    @Column(nullable = false)
    private String heslo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private boolean aktivni = true;
}
