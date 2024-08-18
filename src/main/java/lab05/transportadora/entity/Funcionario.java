package lab05.transportadora.entity;


import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Funcionario extends PessoaFisica implements EntidadeBase{
    private int matricula;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dependente> dependentes;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;

}
