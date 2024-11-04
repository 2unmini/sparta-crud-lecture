package com.example.memo.entity;

import com.example.memo.dto.MemoRequestDto;
import com.example.memo.dto.MemoResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Memo {

    private Long id; // int 타입보다 크고 래퍼 클래스 이기 때문에 null이 포함이 가능해서 Long 타입으로 설정
    private String title;
    private String contents;

    public void update(MemoRequestDto dto) {
        this.title = dto.getTitle();
        this.contents= dto.getContents();
    }

    public void updateTitle(MemoRequestDto dto) {
        this.title= dto.getTitle();
    }
}
