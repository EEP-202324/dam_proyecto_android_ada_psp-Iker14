package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo")
public class TipoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private UsuarioModel curso;

    
}
