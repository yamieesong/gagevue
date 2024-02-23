package kr.happyjob.study.controller.mainlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.service.mainlist.MainListService;
import kr.happyjob.study.vo.mainlist.CodeDeailVO;
import kr.happyjob.study.vo.mainlist.UseDeailVO;

@Controller
public class MainListController {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	@Autowired
	private MainListService mainlistservice;

	/**
	 * 가계부 캘린더/리스트 page - 공통코드 셋팅 
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping("/scm/setCode.do")
	@ResponseBody
	 public List<CodeDeailVO> getCodeList(Model model, @RequestParam Map<String, Object> paramMap, 
	 		HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        return mainlistservice.getCodeList();
    }
	
	
	/**
	 * 가계부 캘린더/리스트 page - 가계부 조회 
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */		
	@RequestMapping("/scm/selectgagevueList.do")
	@ResponseBody
	public Map<String, Object> gagevueList(Model model, @RequestParam Map<String, Object> paramMap, 
	HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
 		logger.info("   - paramMap gagevue Controller param >>>>>  : "+paramMap);

 		// 가계뷰 캘린더/리스트 page 목록 조회
 		List<UseDeailVO> gagevueList = mainlistservice.getgagevueList(paramMap);		
 		// 목록 수 추출
 		int gagevueListCnt = mainlistservice.gagevueListCnt(paramMap);
 		// 수입/지출 토탈 조회
 		List<UseDeailVO> gagevueListTotalCnt = mainlistservice.gagevueListTotalCnt(paramMap);
 		
 		Map<String, Object> resultMap = new HashMap<String, Object>();
 		resultMap.put("gagevueList", gagevueList); 
 		resultMap.put("gagevueListCnt", gagevueListCnt); 
 		resultMap.put("gagevueListTotalCnt", gagevueListTotalCnt); 
 		
 		logger.info("   - paramMap gagevue Controller resultMap >>>>>  : " + resultMap);
 		
 		return resultMap;
	}

	
	/**
	 * 가계부 리스트 page - 상세 조회
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */		
	@RequestMapping("/scm/selectgagevueOne.do")
	@ResponseBody
	public Map<String, Object> gagevueOne (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		String result = "SUCCESS";
		String resultMsg = "조회 되었습니다.";
		
		// 가계부 상세페이지 단건 조회
		UseDeailVO gagevueOne = mainlistservice.selectgagevueOne(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		resultMap.put("gagevueOne", gagevueOne);
		

		return resultMap;
	}
	

	
	/**
	 * 가계부 캘린더/리스트 page - 저장 / 수정 
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */		
	@RequestMapping("/scm/savegagevue.do")
	@ResponseBody
	public Map<String, Object> savegagevue(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String)paramMap.get("action");
		String resultMsg = "";

		int mbr_no = 0;
		
		if ("INSERT".equals(action)) {
			/* 회원관리번호 채번 */
			mbr_no = mainlistservice.mbrNoSeq(paramMap);
			paramMap.put("mbr_no", mbr_no);	
			/* 가계부 캘린더 page - 저장 */
			mainlistservice.gagevueInsert(paramMap);
			resultMsg = "저장 완료했습니다.";
		} else if("UPDATE".equals(action)) {
			/* 가계부 캘린더/리스트 page - 수정 */
			mainlistservice.gagevueUpdate(paramMap);
			resultMsg = "수정 완료했습니다.";
		} else {
			resultMsg = "FALSE : 등록에 실패하였습니다.";
		}

		// 결과값 전송
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultMsg", resultMsg);
	    
	    return resultMap;
	}
 		
	/**
	 * 가계부 캘린더/리스트 page - 삭제
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping("/scm/deletegagevue.do")
	@ResponseBody
	public Map<String, Object> deletegagevue(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("   - paramMap : " + paramMap);

		String result = "SUCCESS";
		String resultMsg = "삭제 되었습니다.";
		
		/* 가계부 캘린더/리스트 page - 삭제 */
		mainlistservice.deletegagevue(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);
		
		logger.info("+ End " + className + ".noticeDelete");
		
		return resultMap;
	}
 		

}