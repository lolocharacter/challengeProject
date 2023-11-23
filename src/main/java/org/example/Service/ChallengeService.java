package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Challenge;
import org.example.mappers.ChallengeMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeMapper challengeMapper;

    public ArrayList<Challenge> getChallengeList(char view_yn) {
        return challengeMapper.getChallengeList(view_yn);
    }

    public Challenge getChallengeDetail(int challenge_id) {
        return challengeMapper.getChallengeDetail(challenge_id);
    }
}
