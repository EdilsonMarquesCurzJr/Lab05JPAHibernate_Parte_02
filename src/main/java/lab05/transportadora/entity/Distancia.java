package lab05.transportadora.entity;


import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Distancia implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float quilometros;

    @ManyToOne
    @JoinColumn(name = "cidade_origem_id")
    private Cidade origem;

    @ManyToOne
    @JoinColumn(name = "cidade_destino_id")
    private Cidade destino;

    public Distancia(float quilometros, Cidade origem, Cidade destino) {
        this.quilometros = quilometros;
        this.origem = origem;
        this.destino = destino;
    }
}
