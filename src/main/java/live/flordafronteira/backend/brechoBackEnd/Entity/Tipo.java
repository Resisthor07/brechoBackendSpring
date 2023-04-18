package live.flordafronteira.backend.brechoBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "tb_tipo", schema = "public")
public class Tipo extends Entidade {
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false)
    private Genero genero;
    @Getter @Setter
    @Column(name="tp_vestuario", nullable = false, length = 100)
    private String tipovestuario;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name="no_estacao")
    private Estacao estacao;
}
