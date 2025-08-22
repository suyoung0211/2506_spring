package org.iclass.board.service;

import java.util.List;

import org.iclass.board.dto.CommunityCommentDTO;
import org.iclass.board.mapper.CommunityCommentsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CommunityCommentsService {
    private CommunityCommentsMapper mapper;

    // 댓글 추가 + 댓글 갯수 업데이트
    @Transactional      // 클래스 레벨로 정의할 수 있음
    // 2개의 sql 실행이 정상적으로 실행되지 않으면 롤백
    public int insert(CommunityCommentDTO dto) {
        int result = mapper.insert(dto);            // sql insert
        mapper.updateCommentCount(dto.getMref());   // sql update
        return result;
    }

    // 댓글 삭제(pk idx) + 댓글 갯수 업데이트(mref)
    @Transactional
    public int delete(int idx, int mref) {
        int result = mapper.delete(idx);
        mapper.updateCommentCount(mref);   // sql update
        return result;
    }

    // 메인글 댓글 목록 가져오기
    public List<CommunityCommentDTO> selectCommentList(int mref) {
        return mapper.selectCommentList(mref);
    }

    // 메인글 댓글 갯수 가져오기
    public int selectCommentCount(int mref) {
        return mapper.selectCommentCount(mref);
    }

    // 메인글 테이블의 댓글 개수 업데이트
    public void updateCommentCount(int mref) {
        mapper.updateCommentCount(mref);
    }
}
