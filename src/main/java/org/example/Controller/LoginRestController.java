package org.example.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.DTO.KakaoDTO;
import org.example.Service.KakaoLoginService;
import org.example.Service.MemberService;
import org.example.JWT.TokenProvider;
import org.example.domain.Member;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.JWT.JwtProperties;

import java.time.Duration;

@RequiredArgsConstructor
@RestController
public class LoginRestController {

    private final KakaoLoginService kakaoLoginService;
    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    /////////////////

    public String sliceToken(String originalToken) {
        return originalToken.split("\\s")[1];
    }

    @GetMapping("/login")
    public ResponseEntity login(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 인가코드로 카카오 소셜 정보를 받아온다.
        KakaoDTO kakaoInfo = kakaoLoginService.getKakaoInfo(request.getParameter("code"));

        if (kakaoInfo == null) {
            return ResponseEntity.ok().body("Fail");
        }

        // 소셜 정보에 일치하는 member를 가져온다.
        Member member = memberService.checkMemberByKakaoInfo(kakaoInfo);

        // member의 정보를 담고 있는 JWT 토큰을 만든다.
        String jwtToken = tokenProvider.generateToken(member, Duration.ofMinutes(10));

        // 헤더에 토큰 추가
        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.getHEADER_STRING(), JwtProperties.getTOKEN_PREFIX() + jwtToken);

        // 토큰 리턴
        return ResponseEntity.ok().headers(headers).body("Success");
    }

//    @GetMapping("/test2")
//    public int test2(HttpServletRequest request) {
//        String jwtToken = sliceToken( request.getHeader("Authorization") );
//        System.out.println(jwtToken) ;
//        return 0;
//    }

}