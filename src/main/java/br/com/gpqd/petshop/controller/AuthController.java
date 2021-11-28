package br.com.gpqd.petshop.controller;

import br.com.gpqd.petshop.controller.form.LoginForm;
import br.com.gpqd.petshop.repository.ClienteRepository;
import br.com.gpqd.petshop.repository.FuncionarioRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    public AuthController(ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository) {
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping("/cliente")
    public ResponseEntity<String> autorizarCliente(@RequestBody LoginForm loginForm) {
        String token = Jwts.builder()
                .setSubject(loginForm.buildCliente(clienteRepository).getId().toString())
                .setIssuer("Petshop")
                .setIssuedAt(new Date())
//                .setExpiration(
//                        Date.from(
//                                LocalDateTime.now().plusMinutes(15L)
//                                        .atZone(ZoneId.systemDefault())
//                                        .toInstant()))
                .compact();
        return ResponseEntity.ok(token);
    }

    @PostMapping("/funcionario")
    public ResponseEntity<String> autorizarFuncionario(@RequestBody LoginForm loginForm) {
        String token = Jwts.builder()
                .setSubject(loginForm.buildFuncionario(funcionarioRepository).getId().toString())
                .setIssuer("Petshop")
                .setIssuedAt(new Date())
//                .setExpiration(
//                        Date.from(
//                                LocalDateTime.now().plusMinutes(15L)
//                                        .atZone(ZoneId.systemDefault())
//                                        .toInstant()))
                .compact();
        return ResponseEntity.ok(token);
    }

}
