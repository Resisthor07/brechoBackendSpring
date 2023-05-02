package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_administrador", schema = "public")
public class Administrador extends Entidade{
    @Getter @Setter
    @Column(name = "no_administrador", nullable = false, unique = true, length = 100)
    private String nome;
    @Getter @Setter
    @Column(name = "no_email", nullable = false, unique = true, length = 100)
    private String email;
    @Getter @Setter
    @Column(name = "no_login", nullable = false, unique = true, length = 30)
    private String login;
    @Getter @Setter
    @Column(name="no_senha", nullable = false, length = 100)
    private String senha;

}
