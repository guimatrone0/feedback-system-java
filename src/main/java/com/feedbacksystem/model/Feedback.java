package com.feedbacksystem.model;

import java.time.LocalDateTime;

public class Feedback {
    private Long id;
    private String texto;
    private String autor;
    private LocalDateTime data;
    private String categoria;
    private int pontuacao; 
    private String sentimento; 
    
  
    public Feedback() {}
    
    public Feedback(String texto, String autor, String categoria, int pontuacao) {
        this.texto = texto;
        this.autor = autor;
        this.categoria = categoria;
        this.pontuacao = pontuacao;
        this.data = LocalDateTime.now();
    }
    

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTexto() {
        return texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public LocalDateTime getData() {
        return data;
    }
    
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }
    
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
   
    public String getSentimento() {
        return sentimento;
    }
    
    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }
    
    
    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", data=" + data +
                ", categoria='" + categoria + '\'' +
                ", pontuacao=" + pontuacao +
                ", sentimento='" + sentimento + '\'' +
                '}';
    }
}