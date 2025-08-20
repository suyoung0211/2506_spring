package org.iclass.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.board.dto.CommunityDTO;

@Mapper
public interface CommunityMapper {
	List<CommunityDTO> selectAll();
	
	CommunityDTO selectByIdx(long idx);
	
	int setReadCount(long idx);

	int getAllCount();

	List<CommunityDTO> selectPageList(Map<Integer, Integer> map);
	
	int insert(CommunityDTO dto);

	int update(CommunityDTO dto);

	int delete(long idx);
}
