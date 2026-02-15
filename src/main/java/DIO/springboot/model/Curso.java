package DIO.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")
public class Curso extends Conteudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Curso_id")
    private int Curso_id;
    @Column(nullable = false)
    private int cargaHoraria;
   
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    @Override
    public double CalcularXP(){
        return 10 * cargaHoraria;
    }
}


