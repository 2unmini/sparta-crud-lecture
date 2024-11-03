package com.example.memo.dto;

import lombok.Getter;

/**
 * 요청 데이터를 처리하는 객체는 일반적으로 RequestDto로 명명한다.
 * 이 MemoRequestDto클래스는 Client의 요청 데이터를 받아준다.
 * 내가 생각할 것
 * Entity객체를 생성하기 위해서 클라이언트로 부터 전달받아야 할 값을 생각한다.
 * 전달 받아야할 값 : title,contents   (id: 서버에서 관리해준다.)
 */
@Getter
public class MemoRequestDto {
    private String title;           // <= 요청 받아야할 데이터는 title과 content 입니다 라고 생각할 것
    private String contents;
}
