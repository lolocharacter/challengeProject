package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Member {
    private int member_id;
    private String nickname;
    private int height;
    private int weight;
    private String name;
    private String birth;
	private int gender; // 남자일시 0 여자일시 1
    private String phone_number;
    private String email;
    private int cash;
    private int point;
    private Date sign_date;

    // 회원가입용 생성자
    public Member(String email){
        this.nickname = "임시 닉네임";
        this.height = 0;
        this.weight = 0;
        this.name = "임시 이름";
        this.birth = "임시 생일";
        this.gender = 0;
        this.phone_number = "010임시임시임시임시";
        this.email = email;
        this.cash = 0;
        this.point = 3000;
        this.sign_date = new Date();
    }

}