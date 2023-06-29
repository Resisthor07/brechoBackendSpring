//package live.flordafronteira.backend.brechoBackEnd.service;
//
//
//import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
//import live.flordafronteira.backend.brechoBackEnd.entity.Tipo;
//import live.flordafronteira.backend.brechoBackEnd.repository.TipoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TipoService extends AbstrataService<TipoRepository, Tipo> {

//
//    @Autowired
//    private TipoRepository tipoRepository;
//
//
//    @Override
//    public String validaObjeto(Tipo objetoParam) {
//
//        if(!objetoParam.getTipoVestuario().matches("[a-zA-Z\\s]{1,100}"))
//        {
//            return "Problema com a formatação do tipo de vestuario";
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean consultaEmBancoVinculoComTabelas(Long id) {
//        return tipoRepository.isInProduto(id);
//    }
//
//    @Override
//    public List<Tipo> consultaEmBancoAtivos() {
//        return tipoRepository.findByAtivo();
//    }
//
//    @Override
//    public Tipo aplicaRegrasDeNegocio(Tipo objetoParam) {
//        return objetoParam;
//    }
//
//    @Override
//    public Tipo filtraDados(Tipo objetoParam) {
//        return objetoParam;
//    }
//}
