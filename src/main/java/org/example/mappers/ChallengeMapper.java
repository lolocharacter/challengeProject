package org.example.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.Challenge;
import java.util.ArrayList;

@Mapper
public interface ChallengeMapper {

    ArrayList<Challenge> getChallengeList(char view_yn);
    Challenge getChallengeDetail(int challenge_id);
}
