package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo")
public class TipoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    
    private String online;
    private String presencial;
    private String semipresencial;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private UsuarioModel curso;
    

    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getOnline() {
		return online;
	}


	public void setOnline(String online) {
		this.online = online;
	}


	public String getPresencial() {
		return presencial;
	}


	public void setPresencial(String presencial) {
		this.presencial = presencial;
	}


	public String getSemipresencial() {
		return semipresencial;
	}


	public void setSemipresencial(String semipresencial) {
		this.semipresencial = semipresencial;
	}


	public UsuarioModel getCurso() {
		return curso;
	}


	public void setCurso(UsuarioModel curso) {
		this.curso = curso;
	}


	
    
    
}
