package DIO.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Conteudo {
  
    protected static final double XP_PADRAO = 10d;
    @Column(length = 50, nullable = false)
    private String titulo;
    @Column(length = 100, nullable = false)
    private String descricao;

    public abstract double CalcularXP();    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Conteudo [titulo=" + titulo + ", descricao=" + descricao + "]";
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}