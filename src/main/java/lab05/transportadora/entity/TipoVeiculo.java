package lab05.transportadora.entity;


import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"veiculos"})
public class TipoVeiculo implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private float peso;
    @OneToMany(mappedBy = "tipoVeiculo")
    private List<Veiculo> veiculos;

    public TipoVeiculo(String descricao, float peso) {
        this.descricao = descricao;
        this.peso = peso;
    }


}
