package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author yacin
 */
@Entity
@Table(name = "seance_cours")
public class SeanceCours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom_cours")
    private String nomCours;

    private Jour jour;

    @Column(name = "heure_debut")
    private LocalTime heureDeb;

    @Column(name = "heure_fin")
    private LocalTime heureFin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof_id", nullable = true)
    private Prof prof;

    public SeanceCours() {
    }

    public SeanceCours(long id, String nomCours, Jour jour, LocalTime heureDeb, LocalTime heureFin) {
        this.id = id;
        this.nomCours = nomCours;
        this.jour = jour;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
    }

    public long getId() {
        return id;
    }

    public String getNomCours() {
        return nomCours;
    }

    public Jour getJour() {
        return jour;
    }

    public LocalTime getHeureDeb() {
        return heureDeb;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public void setJour(Jour jour) {
        this.jour = jour;
    }

    public void setHeureDeb(LocalTime heureDeb) {
        this.heureDeb = heureDeb;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

}
