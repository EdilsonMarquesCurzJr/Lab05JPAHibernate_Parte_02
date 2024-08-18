package lab05.transportadora.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
public class Filial implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;

    @OneToMany(mappedBy = "filial")
    private List<Funcionario> funcionarios;
    @OneToMany(mappedBy = "filial")
    private List<Veiculo> veiculos;
}
