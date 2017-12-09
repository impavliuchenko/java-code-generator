package com.codegen.security;

import com.codegen.security.models.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secret = "codegen";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;

        try {
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            jwtUser = new JwtUser();
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setUserName(body.getSubject());
            jwtUser.setRole((String) body.get("role"));
        }catch (Exception e){
            System.out.println(e);
        }

        return jwtUser;
    }
}
