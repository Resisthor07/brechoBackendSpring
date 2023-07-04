package live.flordafronteira.backend.brechoBackEnd.abstractClasses;
import jakarta.persistence.EntityNotFoundException;
import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.entity.Entidade;
import live.flordafronteira.backend.brechoBackEnd.regrasDeNegocioInterface.aplicacoesDoObjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
public abstract class AbstrataService<Repositorio extends JpaRepository<T, Long>, T extends Entidade> implements aplicacoesDoObjeto<T> {
    @Autowired
    protected Repositorio repository;

    public T encontrarPorId(final Long id) {
        final T objeto = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id nao encontrado"));
        return objeto;
    }

    public List<T> listarTodos() {
        List<T> objetos = this.repository.findAll();
        Assert.isTrue(objetos != null && !objetos.isEmpty(), "Nao foi possivel gerar uma lista dos dados solicitados.");
        return objetos;
    }

    public List<T> encontrarAtivos() {
        final List<T> objetosAtivos = consultaEmBancoAtivos();
        Assert.isTrue((objetosAtivos != null && !objetosAtivos.isEmpty()), "Erro, ativos nao encontrados.");
        return objetosAtivos;
    }

    @Transactional//(rollbackFor = Exception.class)
    public String cadastrar(T objetoParam) {
        try {
            //String erro = validaObjeto(objetoParam);
            //Assert.isTrue(erro == null ? true : false, erro);
            repository.save((objetoParam));
            return "salvo";
        } catch (DataIntegrityViolationException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Transactional
    public Long cadastrarComRetorno(Cliente objetoParam) {
        try {
            Cliente clienteCadastrado = repository.save(objetoParam);
            return clienteCadastrado.getId();
        } catch (DataIntegrityViolationException e) {
            // Trate a exceção adequadamente
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            // Trate a exceção adequadamente
            e.printStackTrace();
            return null;
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public String atualizar(Long id, T objeto) throws Exception {
        if (id != objeto.getId())
            throw new Exception("Erro de identificacao.");
        String erro = validaObjeto(objeto);
        Assert.isTrue(erro == null ? true : false, erro);
        LocalDateTime dataCadastro = repository.findById(id)
                .orElseThrow(
                        () -> new DataIntegrityViolationException("Erro ao manter data de cadastro."))
                .getDataCriacao();
        objeto = filtraDados(objeto);
        objeto.setDataCriacao(dataCadastro);
        repository.save(objeto);
        return "salvo";
    }

    @Transactional(rollbackFor = Exception.class)
    public String deletaDesativa(final Long id) {
        final T objeto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Erro ao deletar: Id nao encontrado."));
        boolean existeVinculo = consultaEmBancoVinculoComTabelas(id);
        if (existeVinculo && objeto.isStatus()) {
            objeto.setStatus(false);
            repository.save(objeto);
            return "Registro desativado com sucesso!";
        } else if (existeVinculo && !objeto.isStatus()) {
            throw new EntityNotFoundException("Registro ja esta desativado.");
        } else {
            repository.delete(objeto);
            return "Registro deletado com sucesso";
        }
    }


}