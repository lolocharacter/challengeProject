package org.example.JWT;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt")
public class JwtProperties {
    private String issuer;
    private String secretKey;

    public static String getTOKEN_PREFIX() {
        return "Bearer ";
    }
    public static String getHEADER_STRING() {
        return "Authorization";
    }
}