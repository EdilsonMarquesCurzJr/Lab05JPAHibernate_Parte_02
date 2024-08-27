package lab05.transportadora.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Veiculo implements EntidadeBase {

    @Id
    private String placa;

    @ManyToOne
    @JoinColumn(name = "tipoVeiculo_id")
    private TipoVeiculo tipoVeiculo;

    @ManyToOne
    private Filial filial;


    public Integer getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", tipoVeiculo=" + tipoVeiculo +
                ", filial=" + filial +
                '}';
    }
}
