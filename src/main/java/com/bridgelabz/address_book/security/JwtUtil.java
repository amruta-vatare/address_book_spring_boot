package com.bridgelabz.address_book.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;

@Component

public class JwtUtil {
   
    @Value("${app-secret}")
    private String TOKEN_SECRET; 

    public String generateToken(int id)   {
        try {
         //to set algorithm
         Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        
         String token = JWT.create()
	        .withClaim("user_id", id)
	        .sign(algorithm);
	        return token;
         
         } catch (JWTCreationException exception) {
            exception.printStackTrace();
            //log Token Signing Failed
         } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public int decodeToken(String token)
    {
       int userid;
       //for verification algorithm
       Verification verification = null;
       try {
           verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
       } catch (IllegalArgumentException  e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       JWTVerifier jwtverifier=verification.build();
       //to decode token
       DecodedJWT decodedjwt=jwtverifier.verify(token);

       Claim claim=decodedjwt.getClaim("user_id");
       userid=claim.asInt();    
       return userid;
           
    }

    public String generateUserToken(String userName)   {
        try {
         //to set algorithm
         Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        
         String token = JWT.create()
	        .withClaim("user_name", userName)
	        .sign(algorithm);
	        return token;
         
         } catch (JWTCreationException exception) {
            exception.printStackTrace();
            //log Token Signing Failed
         } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public String decodeUserToken(String token)
    {
       String  user_name;
       //for verification algorithm
       Verification verification = null;
       try {
           verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
       } catch (IllegalArgumentException  e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       JWTVerifier jwtverifier=verification.build();
       //to decode token
       DecodedJWT decodedjwt=jwtverifier.verify(token);

       Claim claim=decodedjwt.getClaim("user_name");
       user_name=claim.asString();    
       return user_name;
           
    }

   
}
