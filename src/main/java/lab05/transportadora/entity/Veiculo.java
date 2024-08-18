package lab05.transportadora.entity;


import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Veiculo implements EntidadeBase{

    @Id
    private String placa;

    @ManyToOne
    @JoinColumn(name = "tipoVeiculo_id")
    private TipoVeiculo tipoVeiculo;

    @ManyToOne
    private Filial filial;


    @Override
    public Integer getId() {
        return 0;
    }
}
