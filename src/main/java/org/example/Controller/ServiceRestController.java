package org.example.Controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.DTO.*;
import org.example.MsgEntity.*;
import org.example.Service.ChallengeService;
import org.example.Service.MemberService;
import org.example.JWT.TokenProvider;
import org.example.domain.Challenge;
import org.example.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
public class ServiceRestController {

    private final MemberService memberService;
    private final ChallengeService challengeService;
    private final TokenProvider tokenProvider;

    public String sliceToken(String originalToken) {
        return originalToken.split("\\s")[1];
    }

    // 챌린지 리스트를 가져오는 REST
    @GetMapping("/getChallengeList")
    public ResponseEntity<MsgEntity_ChallengeList> getChallengeList(HttpServletRequest request) {
        String jwtToken = sliceToken( request.getHeader("Authorization") );

        // 토큰이 유효하면
        if (tokenProvider.validToken(jwtToken)) {
            ArrayList<Challenge> challengeArrayList = challengeService.getChallengeList('y');
            // 응답에 담아 리턴
            return ResponseEntity.ok().body(new MsgEntity_ChallengeList("Success", challengeArrayList));
        }
        else { // 유효하지 않다면
            // 실패로 리턴
            return ResponseEntity.ok().body(new MsgEntity_ChallengeList("Fail", null));
        }
    }

    // 챌린지 상세 페이지에서 선택한 챌린지 상세 정보를 보여주는 REST
    @GetMapping("/getChallengeDetail")
    public ResponseEntity<MsgEntity_ChallengeDetail> getChallengeDetail(HttpServletRequest request) {
        String jwtToken = sliceToken( request.getHeader("Authorization") ); // 토큰 가져오기

        // 토큰이 유효하면
        if (tokenProvider.validToken(jwtToken)) {
            Challenge challengeDetail = challengeService.getChallengeDetail(  Integer.parseInt(request.getParameter("challenge_id")) );
            // 챌린지 상세 정보를 응답에 담아 리턴
            return ResponseEntity.ok().body(new MsgEntity_ChallengeDetail("Success", challengeDetail));
        }
        else { // 유효하지 않다면
            // 실패로 리턴
            return ResponseEntity.ok().body(new MsgEntity_ChallengeDetail("Fail:DeadToken", null));
        }
    }


    // 내 정보 페이지에 내 정보를 넘겨주는 REST
    @GetMapping("/getMemberData")
    public ResponseEntity<MsgEntity_MemberDTO> getMyData(HttpServletRequest request) {
        String jwtToken = sliceToken( request.getHeader("Authorization") );

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());

        // 토큰이 유효하면
        if (tokenProvider.validToken(jwtToken)) {
            // 계정 정보를 찾아서
            Member member = memberService.findMemberByMemberId( Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()) );

            // myPage에 필요한 정보
            MemberDTO memberDTO = new MemberDTO(
                    member.getNickname(),
                    member.getHeight(),
                    member.getWeight(),
                    member.getName(),
                    member.getBirth(),
                    member.getGender(),
                    member.getPhone_number(),
                    member.getEmail(),
                    member.getCash(),
                    member.getPoint()
            );

            // 응답에 담아 리턴
            return ResponseEntity.ok().body(new MsgEntity_MemberDTO("Success", memberDTO));
        }
        else { // 유효하지 않다면
            // 실패로 리턴
            return ResponseEntity.ok().body(new MsgEntity_MemberDTO("Fail", null));
        }
    }

    @GetMapping("/test")
    public ResponseEntity<MsgEntity_Test> test(HttpServletRequest request) {
        String jwtToken = sliceToken( request.getHeader("Authorization") );

        System.out.println("hello");

        return ResponseEntity.ok().body(new MsgEntity_Test("Success", "Test"));
    }
}
