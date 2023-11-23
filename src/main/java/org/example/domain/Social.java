package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Social {
    private int social_id; // Social 데이터 관리 번호
    private int social_account; // social ID가 저장될 장소, ex) kakao_id = 3051234598
    private String social_email; // social ID의 email이 저장될 장소 ex) social_email = kakao@kakao.com
    private int member_id; // Member 테이블 외래키
    // 연결 날짜 추가하기

    public Social(int social_account, String social_email, int member_id) {
        this.social_account = social_account;
        this.social_email = social_email;
        this.member_id = member_id;
    }
}
