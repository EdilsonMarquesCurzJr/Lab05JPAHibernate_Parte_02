package lab05.transportadora.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CategoriaFrete implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private float percentualAdicional;

    public CategoriaFrete(String nome, String descricao, float percentualAdicional) {
        this.nome = nome;
        this.descricao = descricao;
        this.percentualAdicional = percentualAdicional;
    }
}
