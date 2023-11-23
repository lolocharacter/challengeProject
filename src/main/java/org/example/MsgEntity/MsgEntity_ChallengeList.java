package org.example.MsgEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.domain.Challenge;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class MsgEntity_ChallengeList {
    String message;
    ArrayList<Challenge> challengeList;
}
