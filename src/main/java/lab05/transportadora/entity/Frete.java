package lab05.transportadora.entity;


import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Frete implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int numeroNotaFiscal;
    private BigDecimal valorKmRodado;

    @ManyToOne
    @JoinColumn(name = "veiculo")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "categoriaFrete")
    private CategoriaFrete categoria;

    @OneToMany(mappedBy = "frete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemFrete> itemFretes;

    @ManyToOne
    @JoinColumn(name = "cidadeOrigem_id")
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "cidadeDestino_id")
    private Cidade cidadeDestino;

    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario funcionario;



    public BigDecimal calcularValorFrete() {
        return this.valorKmRodado;
    }
}
