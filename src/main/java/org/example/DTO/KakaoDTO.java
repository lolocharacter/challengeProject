package org.example.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KakaoDTO {
    private int id;
    private String email;
    private String nickname;
}
