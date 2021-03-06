//package com.example;
//
//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.encoding.PasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebMvcSecurity
//@Slf4j
//public class SecurityConfig_new extends WebSecurityConfigurerAdapter {
//   @Override
//   public void configure(WebSecurity web) throws Exception {
//   // 静的リソースは無視するように設定。
//   web.ignoring().antMatchers("/webjars/**", "/css/**", "/jsptest*");
//   }
//   
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    log.info("★★★Security!★★");
//    http.authorizeRequests().antMatchers("/loginForm").permitAll().anyRequest().authenticated();
//    // http.authorizeRequests()
//    // .antMatchers("/**").permitAll().anyRequest().authenticated();
//    
//    // ログインページ関連の情報を指定
//    http.formLogin().loginProcessingUrl("/login").loginPage("/loginForm")
//        .failureUrl("/loginForm?error")/* .defaultSuccessUrl("/customers", true) */
//        .usernameParameter("username").passwordParameter("password").and();
//
//    http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
//        .logoutSuccessUrl("/loginForm");s
//  }
//
//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication().withUser("user").password("password").roleså("USER");
//    auth.inMemoryAuthentication().withUser("user2").password("demo").roles("USER");
//    auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
//  }
//}
