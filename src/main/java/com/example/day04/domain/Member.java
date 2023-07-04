package com.example.day04.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String passwordCheck;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone; //유효성검사에서 Phone 일 수 있으니 재확인
    @Column(nullable = false)
    private String email;
    @Column
    private String sample4_postcode; //기존 변수명: //우편번호
    @Column
    private String sample4_roadAddress; //기존 변수명: //도로명주소
    @Column
    private String sample4_detailAddress; //기존 변수명: //상세주소

    public Member(String userId, String password, String passwordCheck, String name, String phone, String email, String sample4_postcode, String sample4_roadAddress, String sample4_detailAddress){
        this.userId = userId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sample4_postcode = sample4_postcode;
        this.sample4_roadAddress = sample4_roadAddress;
        this.sample4_detailAddress = sample4_detailAddress;
    }

    public Member(MemberRequestDto memberRequestDto) {
        this.userId = memberRequestDto.getUserId();
        this.password = memberRequestDto.getPassword();
        this.passwordCheck = memberRequestDto.getPasswordCheck();
        this.name = memberRequestDto.getName();
        this.phone = memberRequestDto.getPhone();
        this.email = memberRequestDto.getEmail();
        this.sample4_postcode = memberRequestDto.getSample4_postcode();
        this.sample4_roadAddress = memberRequestDto.getSample4_roadAddress();
        this.sample4_detailAddress = memberRequestDto.getSample4_detailAddress();
    }

    public void update(MemberRequestDto memberRequestDto){
        this.userId = memberRequestDto.getUserId();
        this.password = memberRequestDto.getPassword();
        this.passwordCheck = memberRequestDto.getPasswordCheck();
        this.name = memberRequestDto.getName();
        this.phone = memberRequestDto.getPhone();
        this.email = memberRequestDto.getEmail();
        this.sample4_postcode = memberRequestDto.getSample4_postcode();
        this.sample4_roadAddress = memberRequestDto.getSample4_roadAddress();
        this.sample4_detailAddress = memberRequestDto.getSample4_detailAddress();
    }



}
