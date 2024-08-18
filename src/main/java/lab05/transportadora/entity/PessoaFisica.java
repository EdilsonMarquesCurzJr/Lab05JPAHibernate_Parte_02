package lab05.transportadora.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaFisica implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
}
