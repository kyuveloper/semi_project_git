//package com.semiproject.pettales.auth.service;
//
//import com.semiproject.pettales.auth.model.AuthDetails;
//import com.semiproject.pettales.auth.model.UserAuth;
//import com.semiproject.pettales.user.dao.UserRepository;
//import com.semiproject.pettales.user.model.entity.User;
//import com.semiproject.pettales.user.dao.UserRepository;
//import com.semiproject.pettales.user.model.dto.LoginUserDTO;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Map;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
//    private final UserRepository userRepository;
//
//    private final PasswordEncoder encoder;
//
//    @Override
//    @Transactional
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//        log.info("getAttributes : {}", oAuth2User.getAttributes());
//
//        String provider = userRequest.getClientRegistration().getRegistrationId();
//        String providerId = oAuth2User.getAttribute("sub");
//        String userNickName = oAuth2User.getAttribute("name");
////        String userEmail = provider + "_" + providerId;
//        String userEmail = oAuth2User.getAttribute("email");
//        log.info("userEmail : {}", userEmail);
//
//        Optional<User> optionalUser = userRepository.findByUserEmail(userEmail);
//        User user = null;
//
//        if(optionalUser.isEmpty()) {
//            user = user.builder()
//                    .provider(provider)
//                    .providerId(providerId)
//                    .userEmail(userEmail)
//                    .userNickname(userNickName)
//                    .password(encoder.encode("123"))
//                    .userStatus("기본")
//                    .userAuth("USER")
//                    .build();
//            userRepository.save(user);
//        } else {
//            user = optionalUser.get();
//        }
//        System.out.println("userRequest : " + userRequest);
//        System.out.println("getClientRegistration : " + userRequest.getClientRegistration());
//        System.out.println("getAccessToken : " + userRequest.getAccessToken());
//        System.out.println("getAccessToken : " + userRequest.getAccessToken().getTokenValue());
//        System.out.println("getAttributes : " + super.loadUser(userRequest).getAttributes());
//
////        return new AuthDetails(loginUserDTO, oAuth2User.getAttributes());
////        LoginUserDTO loginUserDTO1 = LoginUserDTO.createLoginUserDTO();
//        // 구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수
//
//
//        return super.loadUser(userRequest);
//    }
//}
