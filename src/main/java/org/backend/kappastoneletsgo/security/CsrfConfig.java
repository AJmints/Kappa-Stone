package org.backend.kappastoneletsgo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class CsrfConfig {

    /** Look into this after getting things running **/

//    @Bean
//    public CsrfTokenRepository csrfTokenRepository() {
//        return CookieCsrfTokenRepository.withHttpOnlyFalse();
//    }

}