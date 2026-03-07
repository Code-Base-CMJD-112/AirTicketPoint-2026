package lk.ijse.cmjd112.AirTicketPoint.securityConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JWTUtils {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    private Key key;

    @PostConstruct
    public void init(){
       byte [] keyBytes =  Base64.getDecoder().decode(secret);
       this.key = Keys.hmacShaKeyFor(keyBytes);
    }
    //Token Generate
    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities){
            String role = authorities.stream()
                    .map(GrantedAuthority ::getAuthority)
                    .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(username)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }
    //Token validate
    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    //User name extraction
    public String getUserNameFromToken(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
