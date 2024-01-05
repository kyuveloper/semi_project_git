package com.semiproject.pettales.config;

import com.semiproject.pettales.auth.model.UserAuth;
import com.semiproject.pettales.config.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// USER와 ADMIN의 권한을 부여 해주는 기능
// 로그인에 사용할 세부 정보
// 로그아웃에 사용할 세부 정보

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Autowired
//    private AuthFailHandler authFailHandler;
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){ // 비밀번호 암호화
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth ->{
//            auth.anyRequest().permitAll(); // 모든 요청을 허용하는 설정
//        }).csrf(csrf -> csrf.disable()); // CSRF 공격 방지 기능을 비활성화
//
//        return http.build();
//    }
//}

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private AuthFailHandler authFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){ // 비밀번호 암호화
        return new BCryptPasswordEncoder();
    }

    @Bean // 정적리소스의 대한 요청을 제외하겠다는 설정 static 파일 하위
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }



    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth ->{ //서버의 리소스에 접근 가능한 권한을 설정함
                    auth.requestMatchers("/auth/naver","/auth/login","/user/signup","/user/email-check","/auth/fail","/","/image/**","/js/**","/css/**","/user/nickName-check",
                            "/favicon.ico", "/resources/**", "/error","/user/find-pass","/user/check-answer","/oauth2/authorization/google").permitAll(); // error 999 해결(favicon 이후 코드 추가)
                    // 접근 권한에 "/user/email-check" 없어서 시큐리티가 막아서 값이 안들어 가던거였음
                    // permitAll : 어떠한 사용자든 해당 경로에 접근 할 수 있도록 허용하는 역할
                    // /admin/* 은 ADMIN에 속한 자가 가질 수 있는 권한임

                    auth.requestMatchers("/admin/**").hasAnyAuthority(UserAuth.ADMIN.getAuth());
//                    auth.requestMatchers("/user/**").hasAnyAuthority(UserAuth.USER.getAuth(), UserAuth.ADMIN.getAuth());
                    // (2023-12-24 권한 설정 변경)
                    // (2023-12-25 유저 페이지에 어드민 권한 접근 불가한 오류 수정)

                    // /user/* 는 USER에 속한 자가 가질 수 있는 권한임
                    auth.anyRequest().authenticated(); //anyRequest:모든 요청 authenticated:인증된
                    //인증된 사용자는 전부 사용 가능
                }).formLogin(login ->{
                    login.loginPage("/auth/login"); // 로그인 페이지에 해당되는 서블릿이 존재해야 한다.
                    // login 페이지를 이거로 교체
                    // /auth/login 으로 커스텀하겠다
                    login.usernameParameter("user"); // user의 parameter를 받음 login.html에 있는 name과 이름이 일치해야됨
                    login.passwordParameter("pass"); // pass의 parameter를 받음
                    login.defaultSuccessUrl("/"); // 서블릿이 존재해야 한다.
                    login.failureHandler(authFailHandler); // 실패시 authFailHandler 호출함
                }).logout(logout ->{
                    logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout")); //로그아웃시 보낼 페이지
                    logout.deleteCookies("JSESSIONID"); // JESSIONID라는 쿠키를 삭제한다
                    // JSESSIONID는 톰캣에서 세션을 유지하기 위해 발급하는 키
                    logout.invalidateHttpSession(true); // 세션을 소멸하도록 허용하는 것
                    logout.logoutSuccessUrl("/"); // 로그아웃 성공 시 이동할 페이지 설정
//                }).oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
//                    httpSecurityOAuth2LoginConfigurer.loginPage("/auth/login");
//                    httpSecurityOAuth2LoginConfigurer.defaultSuccessUrl("/");
//                    httpSecurityOAuth2LoginConfigurer.failureHandler(authFailHandler);
                })
                .sessionManagement(session ->{ // 세션 관리
                    session.maximumSessions(1); //session의 허용 개수를 제한, 동시접속 제한
                    session.invalidSessionUrl("/"); // 세션만료시 이동할 페이지
                }).csrf(csrf -> csrf.disable());

        return http.build();
    }
}