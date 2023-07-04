package com.example.day04.service;

import com.example.day04.domain.Member;
import com.example.day04.domain.MemberRepository;
import com.example.day04.domain.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long update(Long id, MemberRequestDto memberRequestDto){
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지않음.")
        );
        member.update(memberRequestDto);
        return member.getId();
    }
}
