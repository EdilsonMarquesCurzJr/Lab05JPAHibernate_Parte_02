package lab05.transportadora.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Cliente extends PessoaFisica {
    private String contato;
    private boolean ativo;

}
