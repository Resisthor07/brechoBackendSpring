package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_imagens", schema="brecho")
public class Foto extends Entidade{
    @Getter @Setter
    @Column(name = "imagem", nullable = false, length = 500)
    private String imagem ;
    @Getter @Setter
    @Column(name = "st_principal", nullable = false)
    private boolean imagemPrincipal;
    @Getter @Setter
    @Column(name = "st_carrossel", nullable = false)
    private boolean compoeCarrossel;

}
