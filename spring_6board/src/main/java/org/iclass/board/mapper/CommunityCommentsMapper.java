package org.iclass.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.board.dto.CommunityCommentDTO;

@Mapper
public interface CommunityCommentsMapper {
    // 댓글 하나 가져오기
    CommunityCommentDTO selectOneByIdx(int idx);

    // 댓글 추가
    int insert(CommunityCommentDTO dto);

    // 댓글 삭제
    int delete(int idx);

    // 메인글 댓글 목록 가져오기
    List<CommunityCommentDTO> selectCommentList(int mref);

    // 메인글 댓글 갯수 가져오기
    int selectCommentCount(int mref);
    // 메인글의 commertCount 컬럼이 없으면 조회할 때 필요 - 지금은 사용 안함

    // 메인글 테이블의 댓글 개수 업데이트
    int updateCommentCount(int mref);
}
