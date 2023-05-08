package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataController;
import live.flordafronteira.backend.brechoBackEnd.entity.Venda;
import live.flordafronteira.backend.brechoBackEnd.repository.VendaRepository;
import live.flordafronteira.backend.brechoBackEnd.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "api/venda")
public class VendaController extends AbstrataController<VendaService, Venda> {
}
