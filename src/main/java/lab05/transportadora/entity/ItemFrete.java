package lab05.transportadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"frete"})
public class ItemFrete implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private float peso;

    @ManyToOne
    @JoinColumn(name = "frete_id")
    private Frete frete;

    public ItemFrete(String descricao, float peso) {
        this.descricao = descricao;
        this.peso = peso;
    }
}
