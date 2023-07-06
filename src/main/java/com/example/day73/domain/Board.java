package com.example.day73.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity // 테이블과 연계
@Getter
@NoArgsConstructor
public class Board extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private String author;
    @Column
    private String title;
    @Column
    private String contents;
    @ColumnDefault("0")
    private int readcount;

    public Board(String author, String title , String contents, int readcount){
        this.author = author;
        this.title = title;
        this.contents = contents;
        this.readcount = readcount;
    }

    public Board(BoardRequestDto boardRequestDto){
        this.author  = boardRequestDto.getAuthor();
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
        this.readcount = boardRequestDto.getReadcount();
    }

    public void update(BoardRequestDto boardRequestDto){
        this.author  = boardRequestDto.getAuthor();
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
        this.readcount = boardRequestDto.getReadcount();
    }

}
