package com.future.phase2.ojekonline.service;

import com.future.phase2.ojekonline.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();
    Member getMember(Long id);
    Member createMember(Member member);
    Member updateMember(Long id, Member member);
    Boolean deleteMember(Long id);

}
