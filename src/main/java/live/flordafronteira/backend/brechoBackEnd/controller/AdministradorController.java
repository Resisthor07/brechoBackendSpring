package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String login = loginRequest.getUsername();
        String senha = loginRequest.getPassword();

        if (administradorService.autenticar(login, senha)) {
            return ResponseEntity.ok("Autenticado com sucesso");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }

    // Classe de requisição para o endpoint de login
    static class LoginRequest {
        private String username;
        private String password;

        // getters e setters

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
