package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;
import org.aspectj.bridge.IMessage;

@Entity
@Table(name = "tb_administrador", schema = "public")
public class Administrador extends Entidade{
    @Getter @Setter
    @NotNull(message = "NOME NULO")
    @NotBlank(message = "NOME DEVE CONTER SOMENTE LETRAS")
    @Min(value = 1, message = "NOME INVALIDO, NOME MINIMO NAO CADASTRADO")
    @Max(value = 100, message = "Numero Máximo atingido de Caractere")
    @Pattern(regexp = "[a-zA-Z\\s]*",message = "NOME INVALIDO")
    @Column(name = "no_administrador", nullable = false, unique = true, length = 100)
    private String nome;
    @Getter @Setter
    @Email(message = "EMAIL INVÁLIDO")
    @Column(name = "no_email", nullable = false, unique = true, length = 100)
    private String email;
    @Getter @Setter
    @Pattern(regexp = "^[a-zA-Z]{6}$", message = "LOGIN INVALIDO")
    @Size(min = 6, max = 6, message = "Precisa Conter somente 6 caracteres")
    @Column(name = "no_login", nullable = false, unique = true, length = 30)
    private String login;
    @Getter @Setter
    @Pattern(regexp = "^[^\\s]+$",message = "NÃO PODE CONTER ESPAÇO NA SENHA")
    @Column(name="no_senha", nullable = false, length = 100)
    private String senha;

}
