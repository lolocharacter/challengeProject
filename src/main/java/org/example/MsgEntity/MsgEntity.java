package org.example.MsgEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.domain.Member;

@AllArgsConstructor
@Data
public class MsgEntity {
    String message;
    Member member;
}