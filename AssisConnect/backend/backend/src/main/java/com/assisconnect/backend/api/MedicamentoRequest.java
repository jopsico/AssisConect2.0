package com.assisconnect.backend.api;

public class MedicamentoRequest {
    private String nome;
    private String dosagem;
    private String via;
    private Long residenteId;
    private String horarioPrevisto;
    private String status;
    private String observacoes;

    // Getters and Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDosagem() { return dosagem; }
    public void setDosagem(String dosagem) { this.dosagem = dosagem; }

    public String getVia() { return via; }
    public void setVia(String via) { this.via = via; }

    public Long getResidenteId() { return residenteId; }
    public void setResidenteId(Long residenteId) { this.residenteId = residenteId; }

    public String getHorarioPrevisto() { return horarioPrevisto; }
    public void setHorarioPrevisto(String horarioPrevisto) { this.horarioPrevisto = horarioPrevisto; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
