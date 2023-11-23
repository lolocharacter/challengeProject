package org.example.MsgEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.domain.Challenge;

@AllArgsConstructor
@Data
public class MsgEntity_ChallengeDetail {
    String message;
    Challenge challenge;
}
