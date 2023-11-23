package org.example.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberDTO {
    String nickname;
    int height;
    int weight;
    String name;
    String birth;
    int gender;
    String phone_number;
    String email;
    int cash;
    int point;

    public MemberDTO(
            String nickname,
            int height,
            int weight,
            String name,
            String birth,
            int gender,
            String phone_number,
            String email,
            int cash,
            int point) {
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.phone_number = phone_number;
        this.email = email;
        this.cash = cash;
        this.point = point;
    }


}
