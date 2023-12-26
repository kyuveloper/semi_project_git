//package com.semiproject.pettales.auth.service;
//
//import com.semiproject.pettales.auth.model.AuthDetails;
//import com.semiproject.pettales.auth.model.UserAuth;
//import com.semiproject.pettales.user.dao.UserRepository;
//import com.semiproject.pettales.user.model.entity.User;
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
//        String loginId = provider + "_" + providerId;
//        log.info("Login ID: {}", loginId);
//
//        Optional<User> optionalUser = userRepository.findByLoginId(loginId);
//        User user = null;
//
//        if(optionalUser.isEmpty()) {
//            user = User.builder()
//                    .provider(provider)
//                    .providerId(providerId)
//                    .password(encoder.encode("111"))
//                    .userEmail("dummy@example.com")
//                    .userNickname("default")
//                    .userStatus("기본")
//                    .userAuth("USER")
//                    .build();
//            userRepository.save(user);
//        } else {
//            user = optionalUser.get();
//        }
//        return new AuthDetails(user, oAuth2User.getAttributes());
//    }
//}
