package com.example.day73.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
public class Item extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String desc;
    @Column(nullable = false)
    private String shortDesc;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private String category;

    private String fileName;

    private String filePath;

    public Item(ItemRequestDto itemRequestDto) {
        this.title = itemRequestDto.getTitle();
        this.category = itemRequestDto.getCategory();
        this.desc = itemRequestDto.getDesc();
        this.shortDesc = itemRequestDto.getShortDesc();
        this.price = itemRequestDto.getPrice();
        this.fileName = itemRequestDto.getUploadFile().getName();
        this.filePath = "/images/"+itemRequestDto.getUploadFile().getOriginalFilename();
    }
    public void update(ItemRequestDto itemRequestDto){
        this.title = itemRequestDto.getTitle();
        this.category = itemRequestDto.getCategory();
        this.desc = itemRequestDto.getDesc();
        this.shortDesc = itemRequestDto.getShortDesc();
        this.price = itemRequestDto.getPrice();
        this.fileName = itemRequestDto.getUploadFile().getName();
        this.filePath = "/images/"+itemRequestDto.getUploadFile().getOriginalFilename();
    }
}