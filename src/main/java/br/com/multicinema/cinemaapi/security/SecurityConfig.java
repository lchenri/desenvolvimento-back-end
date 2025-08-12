package br.com.multicinema.cinemaapi.security;

import br.com.multicinema.cinemaapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ClienteService clienteService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(ClienteService clienteService, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.clienteService = clienteService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public OncePerRequestFilter jwtFilter(){
        return new JwtAuthFilter(jwtService, clienteService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(clienteService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()


                // APIs de autenticação - públicas
                .antMatchers("/api/v1/clientes/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/clientes").permitAll() // registro público

                // APIs públicas (não necessitam autenticação)
                .antMatchers("/api/v1/filmes/**").permitAll()
                .antMatchers("/api/v1/generos/**").permitAll()
                .antMatchers("/api/v1/sessoes/**").permitAll()
                .antMatchers("/api/v1/unidades/**").permitAll()
                .antMatchers("/api/v1/salas/**").permitAll()
                .antMatchers("/api/v1/fileiras/**").permitAll()
                .antMatchers("/api/v1/cadeiras/**").permitAll()
                .antMatchers("/api/v1/tipos-sessao/**").permitAll()
                .antMatchers("/api/v1/intervalos-exibicao/**").permitAll()
                .antMatchers("/api/v1/imagens/**").permitAll()

                // APIs que necessitam autenticação de usuário comum
                .antMatchers("/api/v1/clientes/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/pedidos/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/ingressos/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/cartoes/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/enderecos/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/cupons-desconto/**").hasAnyRole("USER", "ADMIN")

                // APIs administrativas (apenas funcionários/admin)
                .antMatchers("/api/v1/funcionarios/**").hasRole("ADMIN")
                .antMatchers("/api/v1/items-bomboniere/**").hasRole("ADMIN")

                // Qualquer outra requisição precisa de autenticação
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }



    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/v2/api-docs",
                "/v3/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/swagger-ui/**",
                "/webjars/**"
        );
    }
}
