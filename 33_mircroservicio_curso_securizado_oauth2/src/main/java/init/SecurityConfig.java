package init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

//	@Bean
//	public InMemoryUserDetailsManager users() {
//		List<UserDetails> usuarios=List.of(
//				User.withUsername("user1")
//				.password("{noop}user1")
//				.roles("USERS")
//				.build(),
//				User.withUsername("user2")
//				.password("{noop}user2")
//				.roles("OPERATORS")
//				.build(),
//				User.withUsername("admin")
//				.password("{noop}admin")
//				.roles("USERS","ADMINS")
//				.build());
//		return new InMemoryUserDetailsManager(usuarios);
//	} 
	
	//REEMPLAZAMOS POR UNO CON CONEXION A LA BBDD
	//
//	@Bean
//	public JdbcUserDetailsManager users() {
//		DriverManagerDataSource ds=new DriverManagerDataSource();
//		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/springsecurity");
//		ds.setUsername("root");
//		ds.setPassword("root");
//		JdbcUserDetailsManager jdbc=new JdbcUserDetailsManager(ds);
//		jdbc.setUsersByUsernameQuery("select user,pwd,enabled from users where user=?");
//		jdbc.setAuthoritiesByUsernameQuery("select user,rol from roles where user=?");
//		return jdbc;
//	}
	
	/// LA AUTENTICACION AHORA LO REALIZA OAUTH2
	@Autowired
	JwtOauthConverter Converter;
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
			http
					.csrf(c->c.disable())
					.authorizeHttpRequests(aut->aut.requestMatchers(HttpMethod.GET, "/buscar/*").authenticated()
											.requestMatchers(HttpMethod.GET, "/recuperarTodos").authenticated()
											.requestMatchers(HttpMethod.POST, "/alta").hasRole("ADMINS")
											.requestMatchers(HttpMethod.DELETE, "/eliminar/*").hasAnyRole("ADMINS","OPERATORS")
											.requestMatchers(HttpMethod.PUT, "/actualizar").hasAnyRole("OPERATORS")
											.anyRequest().permitAll()
											
										  )
					.oauth2ResourceServer(oauth2ResourceServer->  oauth2ResourceServer.jwt(jwt->jwt 
																								 .jwtAuthenticationConverter(Converter))) 
																								 .sessionManagement(sessionManagement-> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
																								 												.httpBasic(Customizer.withDefaults());
			return http.build();
	} 
}
