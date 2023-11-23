package org.example.MsgEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.DTO.MemberDTO;

@AllArgsConstructor
@Data
public class MsgEntity_MemberDTO {
    String message;
    MemberDTO member;
}
