package lab05.transportadora.entity;


import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
public class TipoVeiculo implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private float peso;
    @OneToMany(mappedBy = "tipoVeiculo")
    private List<Veiculo> veiculos;

}
