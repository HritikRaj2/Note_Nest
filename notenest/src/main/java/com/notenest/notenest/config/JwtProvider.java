package com.notenest.notenest.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {
    private static SecretKey key= Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    public static String generateToken (Authentication auth){
        String jwt= Jwts.builder()
                .setIssuer("Note Nest").setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+8600000))
                .claim("email",auth.getName())
                .signWith(key)
                .compact();

        return jwt;

    }
    public static String getEmailFromToken(String jwt){
//        jwt=jwt.substring(7);
        Claims claims= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

        String email=String.valueOf(claims.get("email"));
        return email;
    }
}
