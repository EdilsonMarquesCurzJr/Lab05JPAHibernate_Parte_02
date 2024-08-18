package lab05.transportadora.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CategoriaFrete implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private float percentualAdicional;

    @ManyToOne
    @JoinColumn(name = "frete_id")
    private Frete frete;
}
