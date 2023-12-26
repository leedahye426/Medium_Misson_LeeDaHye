package com.ll.medium.domain.member.member.service;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create(String username, String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        member.setCreateDate(LocalDateTime.now());

        memberRepository.save(member);
        return member;
    }

    public Member getMember(String username) {
        Optional<Member> member = memberRepository.findByUsername(username);
        if(member.isEmpty()) {
            throw new RuntimeException("entity not found");
        }
        return member.get();
    }
}
