package com.future.phase2.ojekonline.serviceimpl;

import com.future.phase2.ojekonline.entity.Member;
import com.future.phase2.ojekonline.repository.MemberRepository;
import com.future.phase2.ojekonline.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    @Override
    public Member getMember(Long id){
        Member existMember = memberRepository.findOne(id);
        if (existMember != null) return existMember;
        else throw new RuntimeException("Member not found!");
    }

    @Override
    public Member createMember(Member member){
        Member existMember = memberRepository.findOne(member.getId());
        if (existMember == null) {
            return memberRepository.save(member);
        }
        else throw new RuntimeException("Member is already exists!");
    }

    @Override
    public Member updateMember(Long id, Member member){
        Member existMember = memberRepository.findOne(id);
        if (existMember != null){
            existMember.setName(member.getName());
            existMember.setBalance(member.getBalance());
            return memberRepository.save(existMember);
        }
        else throw new RuntimeException("Member is not found!");
    }

    @Override
    public Boolean deleteMember(Long id){
        Member existMember = memberRepository.findOne(id);
        if (existMember != null) {
            memberRepository.delete(id);
            return true;
        }
        else throw new RuntimeException("Member is not found!");
    }
}
