package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "tb_tipo", schema = "brecho")
public class Tipo extends Entidade {
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tp_genero", nullable = false)
    @NotNull(message = "Gênero é obrigatório.")
    private Genero genero;
    @Getter @Setter
    @Column(name="tp_vestuario", nullable = false, length = 100)
    @NotBlank(message = "Tipo não pode ser vazio.")
    @NotNull(message = "Tipo não pode ser nulo.")
    @Size(min = 2, max = 100, message = "Tipo tem que ser em um tamanho válido de mínimo 2 e de máximo 100 caracteres")
    private String tipoVestuario;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name="no_estacao")
    private Estacao estacao;
}
