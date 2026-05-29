package com.assisconnect.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "dosagem", nullable = false)
    private String dosagem;

    @Column(name = "via", nullable = false)
    private String via;

    @ManyToOne(optional = false)
    @JoinColumn(name = "residente_id", nullable = false)
    private Idoso residente;

    @Column(name = "horario_previsto", nullable = false)
    private String horarioPrevisto;

    @Column(name = "status", nullable = false, length = 20)
    private String status = "pendente";

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDosagem() { return dosagem; }
    public void setDosagem(String dosagem) { this.dosagem = dosagem; }

    public String getVia() { return via; }
    public void setVia(String via) { this.via = via; }

    public Idoso getResidente() { return residente; }
    public void setResidente(Idoso residente) { this.residente = residente; }

    public String getHorarioPrevisto() { return horarioPrevisto; }
    public void setHorarioPrevisto(String horarioPrevisto) { this.horarioPrevisto = horarioPrevisto; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
