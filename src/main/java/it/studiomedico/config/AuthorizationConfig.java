package it.studiomedico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import it.pasqualecavallo.studentsmaterial.authorization_framework.config.DefinitelyBasicAuthorizationFrameworkAutoconfiguration;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ExclusionPatterEvaluator;

@Configuration
@Import(DefinitelyBasicAuthorizationFrameworkAutoconfiguration.class)
public class AuthorizationConfig {


    @Bean
    public ExclusionPatterEvaluator exclusionPatterEvaluator() {
        return new ExclusionPatterEvaluator().mustExcludeAntPathMatchers("/swagger-ui", "/swagger-ui/**", "/v3", "/v3/**");
    }

}
