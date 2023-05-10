package live.flordafronteira.backend.brechoBackEnd.regrasDeNegocioInterface;

import java.util.List;

public interface aplicacoesDoObjeto<T> {

    String validaObjeto(T objetoParam);
    boolean consultaEmBancoVinculoComTabelas(Long id);
    List<T> consultaEmBancoAtivos();
    T aplicaRegrasDeNegocio(T objetoParam);
    T filtraDados(T objetoParam);
}
