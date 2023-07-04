package com.example.day04.controller;

import com.example.day04.domain.Member;
import com.example.day04.domain.MemberRepository;
import com.example.day04.domain.MemberRequestDto;
import com.example.day04.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/api/members")//생성
    public Member createMember(@RequestBody MemberRequestDto requestDto){
        Member member = new Member(requestDto);
        return memberRepository.save(member);
    }

    @GetMapping("/api/members")
    public List<Member> getMember(){
        return memberRepository.findAll();
    }

    @DeleteMapping("/api/members/{id}")
    public Long deleteMember(@PathVariable Long id){
        memberRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/members/{id}")
    public Long updateMember(@PathVariable Long id, @RequestBody MemberRequestDto requestDto){
        memberService.update(id, requestDto);
        return id;
    }

    @GetMapping("/api/members/{id}")
    @ResponseBody
    public Member memberOne(@PathVariable Long id){
        Member member = memberRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디는 존재하지 않습니다.")
        );
        return member;
    }

}
