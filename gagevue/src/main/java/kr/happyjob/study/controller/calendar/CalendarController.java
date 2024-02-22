package kr.happyjob.study.controller.calendar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kr.happyjob.study.service.calendar.CalendarService;
import kr.happyjob.study.vo.notice.NoticeModel;

@Controller
@RequestMapping("/system/")
public class CalendarController {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	
	@Autowired
	private CalendarService calendarService;
	
	// 공지사항 신규등록, 업데이트
		@RequestMapping("calendarSave.do")
		@ResponseBody
		public Map<String, Object> noticeSave(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
			
			logger.info("+ Start " + className + ".noticeSave");
			logger.info("   - paramMap : " + paramMap);
			
			String action = (String)paramMap.get("action");
			String resultMsg = "";
			
			// 사용자 정보 설정
			//paramMap.put("loginId", session.getAttribute("loginId"));
			
			logger.info("loginId : " + paramMap.get("loginId"));
			
			if ("I".equals(action)) {
				// 그룹코드 신규 저장
				//noticeService.insertNotice(paramMap,request);
				resultMsg = "SUCCESS";
			} else if("U".equals(action)) {
				// 그룹코드 수정 저장
				//noticeService.updateNotice(paramMap,request);
				resultMsg = "UPDATED";
				System.out.println(paramMap);
			} else {
				resultMsg = "FALSE : 등록에 실패하였습니다.";
			}
			
			//결과 값 전송
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("resultMsg", resultMsg);
		    
		    return resultMap;
		}
	
	// 공통코드 조회
			@RequestMapping("codeList.do")
			@ResponseBody
			public Map<String, Object> codeList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
				
				logger.info("+ Start " + className + ".noticeSave");
				logger.info("   - paramMap : " + paramMap);
				
				
				String resultMsg = "";
	
				
				//결과 값 전송
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("resultMsg", resultMsg);
			    
			    return resultMap;
			}
	
	
	
}