package com.example.memo.controller;

import com.example.memo.dto.MemoRequestDto;
import com.example.memo.dto.MemoResponseDto;
import com.example.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 메모 생성 API를 만들기 위해 컨트롤러 생성
 * 내가 이해한 내용 : RequestDto의 필드들을 Memo(엔티티)객체로 변환 후  Id를 뽑아내고 DB에 저장 후 Memor값을 Response(응답)으로 넘기는 개념인것 같다.
 */
@RestController
@RequestMapping("/memos") //공통된 url
public class MemoController {

    private final Map<Long, Memo> memoList =new HashMap<>(); // 데이터베이스를 통한 데이터 저장이 아닌 자료구조 HashMap을 통한 데이터 저장
    @PostMapping
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto dto){ //리턴 타입은 응답 객체인 ResponseDto 설정 , 클라이언트로 부터 json형식데이터를 요청 받았을 때 파라미터로 바로 바인딩
        //- 식별자가 1씩 증가하도록 만듦 (중복을 막기 위함)
       Long memoId= memoList.isEmpty() ? 1: Collections.max(memoList.keySet()) +1; // memoList가 비었다면 1,하나라도 들어있다면 memoList의 키 값들을 나열해 그중 큰 값+1을 반환
        //- 요청 받은 데이터로 Memo 객체를 생성
        Memo memo=new Memo(memoId,dto.getTitle(),dto.getContents());
        //- Inmemory DB에 Memo 저장
        memoList.put(memoId,memo);

        return new MemoResponseDto(memo);
    }

    @GetMapping("/{id}")
    public MemoResponseDto findMemoById(@PathVariable Long id) {// Id를 사용해 메모를 조회한다.

        Memo memo = memoList.get(id);
        return new MemoResponseDto(memo);

    }
    @PutMapping("/{id}")
    public MemoResponseDto updateMemoById(@PathVariable Long id, @RequestBody MemoRequestDto dto){

        Memo memo=memoList.get(id);

        memo.update(dto);

        return new MemoResponseDto(memo);

    }
    @DeleteMapping("/{id}")
    public void deleteMemoById(@PathVariable Long id) {
        memoList.remove(id);
    }
}
