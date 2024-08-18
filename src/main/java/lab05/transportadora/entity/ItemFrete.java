package lab05.transportadora.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class ItemFrete implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private float peso;

    @ManyToOne
    @JoinColumn(name = "frete_id")
    private Frete frete;
}
