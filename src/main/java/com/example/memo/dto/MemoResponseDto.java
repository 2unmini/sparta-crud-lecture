package com.example.memo.dto;

import com.example.memo.entity.Memo;
import lombok.Getter;

/**
 * 응답 데이터를 처리하는 객체는 일반적으로 ResponseDto로 명명한다.
 * 응답할때는 Memo라는 객체가 생성되고 나서 저장될때는 식별자가 존재한다.(상황에 따라서 다르다.)
 * 그러므로 ResponseDto는 3가지 필드를 가진다.
 */
@Getter
public class MemoResponseDto {

    private Long id;
    private String title;
    private String contents;

    public MemoResponseDto(Memo memo){
        this.id=memo.getId();
        this.title=memo.getTitle();
        this.contents= memo.getContents();
    }

}
