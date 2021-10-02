package br.com.gpqd.petshop.config.security;

import br.com.gpqd.petshop.model.Funcionario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenService {

    @Value("${desafio.jwt.secret}")
    private String secret;

    public String generate(Authentication authentication) {
        Funcionario funcionario = (Funcionario) authentication.getPrincipal();
        Date now = new Date();
        int expiration = 1800000; //30 minutos
        Date expirationDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setIssuer("Desafio Opus Software")
                .setSubject(funcionario.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getFuncionarioId(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());

    }
}
