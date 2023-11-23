package org.example.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.Member;

@Mapper
public interface MemberMapper {

    Member findByEmail(String email);
    Member findByMemberId(int member_id);
    int addMember(Member member);
}