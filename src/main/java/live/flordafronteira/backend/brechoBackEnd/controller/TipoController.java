package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataController;
import live.flordafronteira.backend.brechoBackEnd.entity.Tipo;
import live.flordafronteira.backend.brechoBackEnd.repository.TipoRepository;
import live.flordafronteira.backend.brechoBackEnd.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tipo")
public class TipoController extends AbstrataController<TipoService, Tipo> {

}
