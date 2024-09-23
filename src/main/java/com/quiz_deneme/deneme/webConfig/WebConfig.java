package com.quiz_deneme.deneme.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm endpoint'ler için CORS'u etkinleştir
                .allowedOrigins("http://localhost:3000")  // React uygulamanın adresi
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")  // Gerekli tüm header'ları izin ver
                .allowCredentials(true);  // Çerez ve kimlik doğrulama bilgilerini kabul et
    }
}
