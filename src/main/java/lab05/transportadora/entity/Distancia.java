package lab05.transportadora.entity;


import lombok.Data;

import jakarta.persistence.*;


@Entity
@Data
public class Distancia implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int quilometros;

    @ManyToOne
    @JoinColumn(name = "cidade_origem_id")
    private Cidade origem;

    @ManyToOne
    @JoinColumn(name = "cidade_destino_id")
    private Cidade destino;
}
