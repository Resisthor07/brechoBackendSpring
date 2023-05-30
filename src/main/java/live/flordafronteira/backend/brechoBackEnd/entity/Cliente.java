package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;
import org.hibernate.envers.*;

@Entity
@Audited
@AuditTable(value="audit_clientes", schema = "audit")
@Table(name = "tb_clientes", schema = "brecho")
public class Cliente extends Entidade {
    @Getter @Setter
    @Column(name = "no-cliente", nullable = false, length = 150)
    @NotNull(message = "Nome inválido ou nulo.") @NotBlank(message = "Nome inválido ou nulo.")
    @Size(min = 5, max = 150, message = "Nome inválido, não pode ser inferior a 5 caracteres ou superior a 150 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Nome não pode conter caracteres especiais")
    private String nome;
    @Getter @Setter
    @Column(name = "num-telefone", nullable = false, length=20)
    @Pattern(regexp = "^[0-9]{2} [0-9]{4,5}-[0-9]{4}$", message = "Telefone inválido.")
    private String telefone;
    @Getter @Setter
    @Column(name = "no-email", nullable = false, length = 150, unique = true)
    @Email(message = "email inválido.")
    @Size(max = 150, message = "O email não pode ultrpassar 150 caracteres")
    private String email;
    @Getter @Setter
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "CEP inválido.")
    @NotNull(message = "CEP não informado.") @NotBlank(message = "CEP não informado.") @NotEmpty(message = "CEP não informado.")

    @Column(name = "num_cep", nullable = false, length = 10)

    private String cep;
    @Getter @Setter
    @Column(name = "tp-logradouro", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDeLogradouro tipoLogradouro;
    @Getter @Setter
    @Column(name = "no-logradouro", nullable = false, length = 150)
    @Size(min = 1, max = 150, message = "O nome do logradouro não pode ser menor que um caracter e não pode ultrapassar 150 caracteres.")
    private String logradouro;
    @Getter @Setter
    @Column(name = "num-residencia", length=10)
    @NotNull(message = "Nº inválido") @NotBlank(message = "Nº inválido") @NotEmpty(message = "Nº inválido")
    @Size(max = 10, message = "Não pode ultrapassar 10 caracteres")
    private String numResidencia;
    @Getter @Setter
    @Column(name = "no-bairro", nullable = false, length = 150)
    @NotNull(message = "Bairro inválido") @NotBlank(message = "Bairro inválido") @NotEmpty(message = "Bairro inválido")
    @Size(min = 10, max = 150, message = "Nome do bairro não pode ser inferiro a 10 caracteres nem superior a 150.")
    private String bairro;
    @Getter @Setter
    @Column(name = "ds-ptreferencia", length = 300)
    private String pontoReferencia;

}
