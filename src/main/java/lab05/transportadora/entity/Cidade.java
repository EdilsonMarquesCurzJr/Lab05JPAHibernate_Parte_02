package lab05.transportadora.entity;


import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"fretesOrigem", "fretesDestino"})
public class Cidade implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uf;
    private String estado;

    @OneToMany(mappedBy = "cidadeOrigem")
    private List<Frete> fretesOrigem;
    @OneToMany(mappedBy = "cidadeDestino")
    private List<Frete> fretesDestino;
    /*
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }*/

    public Cidade(String uf, String estado) {
        this.uf = uf;
        this.estado = estado;
    }
}
