package kr.happyjob.study.service.mainlist;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.mainlist.MainListMapper;
import kr.happyjob.study.vo.mainlist.CodeDeailVO;
import kr.happyjob.study.vo.mainlist.UseDeailVO;

@Service
public class MainListService {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	@Autowired
	private MainListMapper mainlistMapper;
	
	/* 가계부 리스트 page - 공통코드 셋팅 */
	public List<CodeDeailVO> getCodeList() {
		return mainlistMapper.getCodeList();
	}
	
	/* 가계부 리스트 page - 가계부 조회 */
	public List<UseDeailVO> getgagevueList(Map<String, Object> paramMap) throws Exception{
		return mainlistMapper.getgagevueList(paramMap);
	}

	/* 가계부 리스트 page - 가계부 목록 건수 */
	public int gagevueListCnt(Map<String, Object> paramMap) {
		return mainlistMapper.gagevueListCnt(paramMap);
	}

	/* 가계부 리스트 page - 상세 조회 */
	public UseDeailVO selectgagevueOne(Map<String, Object> paramMap) throws Exception{
		return mainlistMapper.selectgagevueOne(paramMap);
	}

	/* 가계부 리스트 page - 수정 */
	public int gagevueUpdate(Map<String, Object> paramMap) {
		return mainlistMapper.gagevueUpdate(paramMap);
		
	}

	/* 가계부 리스트 page - 수입/지출 토탈 조회 */
	public List<UseDeailVO> gagevueListTotalCnt(Map<String, Object> paramMap) {
		return mainlistMapper.gagevueListTotalCnt(paramMap);
	}


}
