package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.DTO.KakaoDTO;
import org.example.domain.Member;
import org.example.domain.Social;
import org.example.mappers.MemberMapper;
import org.example.mappers.SocialMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final SocialMapper socialMapper;
    public Member checkMemberByKakaoInfo(KakaoDTO kakaoInfo) {

        Member newMember;

        // social 테이블에 정보가 있는지 확인
        if (socialMapper.findSocialBySocialAccount(kakaoInfo.getId()) == null) { // 정보가 없다면 계정이 없는 것, 회원 정보 등록
            // member 생성
            newMember = new Member(kakaoInfo.getEmail());

            int newMember_id = memberMapper.addMember(newMember);

            // social 객체 생성
            Social newSocial = new Social(kakaoInfo.getId(), kakaoInfo.getEmail(), 1);
            // social 객체에 member_id를 set
            newSocial.setMember_id(newMember_id);

            // social 테이블에 social 객체 등록
            socialMapper.addSocial(newSocial);

            newMember = memberMapper.findByMemberId(newMember_id);
        }
        else { // 정보가 있다면 계정이 있는 것
            int member_id = socialMapper.findSocialBySocialAccount(kakaoInfo.getId()).getMember_id();
            newMember = memberMapper.findByMemberId(member_id);
        }

        return newMember;
    }

    public Member findMemberByMemberId(int member_id) {
        return memberMapper.findByMemberId(member_id);
    }
}
