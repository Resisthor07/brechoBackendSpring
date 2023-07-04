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
    /*@Pattern(regexp = "^[a-zA-Z]{9}$", message = "LOGIN INVALIDO")
    @Size(min =9 , max = 9, message = "Precisa Conter somente 9 caracteres")*/
    @Column(name = "no_login", nullable = false, unique = true)
    private String login;
    @Getter @Setter
    /*@Pattern(regexp = "^[^\\s]+$",message = "NÃO PODE CONTER ESPAÇO NA SENHA")*/
    @Column(name="no_senha", nullable = false, length = 100)
    private String senha;

}
