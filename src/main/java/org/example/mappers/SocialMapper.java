package org.example.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.Member;
import org.example.domain.Social;

@Mapper
public interface SocialMapper {
    Social findSocialBySocialAccount(int social_account);
    int addSocial(Social social);
}