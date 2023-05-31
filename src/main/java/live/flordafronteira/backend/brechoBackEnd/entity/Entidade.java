package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@MappedSuperclass

public abstract class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", nullable = false, unique = true)
    protected Long id;
    @Getter @Setter
    @Column(name = "dt_criacao", nullable = false)
    //@NotNull(message = "nao pode ser nulo.")
    private LocalDateTime dataCriacao;
    @Getter @Setter
    @Column(name = "dt_atualizacao")
    private LocalDateTime dataModificacao;
    @Getter @Setter
    @Column(name = "st_ativo", nullable = false)
    private boolean status;

    @PrePersist
    public void prePersist(){
        this.dataCriacao=LocalDateTime.now();
        this.status=true;
    }

    @PreUpdate
    public void preUpdate(){
        this.dataModificacao=LocalDateTime.now();
    }




}
