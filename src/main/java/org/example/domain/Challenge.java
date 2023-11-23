package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Challenge {
    private int challenge_id;
    private String challenge_title;
    private String challenge_subtitle;
    private int challenge_fee;
    private int challenge_reward;
    private int challenge_level;
    private int challenge_begin_to_end;
    private char view_yn;
}
