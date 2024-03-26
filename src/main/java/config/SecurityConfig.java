//package config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import service.CustomUserDetailsService;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final CustomUserDetailsService userDetailsService;
//
//    // Injeção baseada em construtor
//    public SecurityConfig(CustomUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Desabilita CSRF
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//                        .requestMatchers("/api/reservations/**", "/api/review/**").hasAuthority("ROLE_CUSTOMER")
//                        .requestMatchers("/api/restaurants/**").hasAuthority("ROLE_RESTAURANT")
//                        .anyRequest().authenticated())
//                .httpBasic(withDefaults()); // Utiliza autenticação básica
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Configuração global que aplica o UserDetailsService e o PasswordEncoder
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//}