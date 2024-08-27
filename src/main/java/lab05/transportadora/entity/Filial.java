package lab05.transportadora.entity;

import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"funcionarios", "veiculos"})
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

    public Filial(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
