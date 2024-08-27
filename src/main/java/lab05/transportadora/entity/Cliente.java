package lab05.transportadora.entity;

import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "pessoa_id")
@SuperBuilder
@NoArgsConstructor
public class Cliente extends PessoaFisica {
    private String contato;
    private boolean ativo;

}


