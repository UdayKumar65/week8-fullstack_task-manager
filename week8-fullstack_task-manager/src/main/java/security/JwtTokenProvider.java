package security;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

 private final String secret = "secret";

 public String generateToken(String username){

  return ((Object) Jwts.builder())
    .setSubject(username)
    .setIssuedAt(new Date())
    .setExpiration(new Date(System.currentTimeMillis()+86400000))
    .signWith(SignatureAlgorithm.HS256,secret)
    .compact();

 }

}