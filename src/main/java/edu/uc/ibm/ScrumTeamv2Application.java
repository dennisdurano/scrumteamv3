package edu.uc.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@SpringBootApplication
public class ScrumTeamv2Application {

	public static void main(String[] args) {
		SpringApplication.run(ScrumTeamv2Application.class, args);
	}
	
	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled=true)
	static class SecurityConfiguration extends WebSecurityConfigurerAdapter{

		//@Override
		//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			//super.configure(auth);
			//auth.inMemoryAuthentication()
			    
				//.withUser("user").password("user").roles("USER").and()
				//.withUser("admin").password("user").roles("USER","ADMIN");
		//}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			super.configure(http);

			http
            // your security config here
            .authorizeRequests()
            .antMatchers(HttpMethod.TRACE, "/**").denyAll()
            .antMatchers("/admin/**").authenticated()
            .anyRequest().permitAll()
            .and().httpBasic()
            .and().headers().frameOptions().disable()
            .and().csrf().disable()
            .headers()
            // the headers you want here. This solved all my CORS problems! 
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, GET,PUT,DELETE"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Credentials", "true"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization"));
		}
		
	}

}
