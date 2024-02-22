package kr.happyjob.study.repository.mainlist;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.mainlist.CodeDeailVO;
import kr.happyjob.study.vo.mainlist.UseDeailVO;

@Mapper
public interface MainListMapper {
	
	/* 가계부 리스트 page - 공통코드 셋팅 */
	List<CodeDeailVO> getCodeList();
	
	/* 가계부 리스트 page - 가계부 조회 */
	List<UseDeailVO> getgagevueList(Map<String, Object> paramMap) throws Exception;

	/* 가계부 리스트 page - 가계부 목록 건수 */
	int gagevueListCnt(Map<String, Object> paramMap);

	/* 가계부 리스트 page - 상세 조회 */
	UseDeailVO selectgagevueOne(Map<String, Object> paramMap) throws Exception;

	/* 가계부 리스트 page - 수정 */
	int gagevueUpdate(Map<String, Object> paramMap);

	/* 가계부 리스트 page - 수입/지출 토탈 조회 */
	List<UseDeailVO> gagevueListTotalCnt(Map<String, Object> paramMap);

}
