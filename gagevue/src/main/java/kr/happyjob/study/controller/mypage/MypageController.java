package kr.happyjob.study.controller.mypage;

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

import kr.happyjob.study.service.mypage.MypageService;
import kr.happyjob.study.vo.mypage.MypageModel;

@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	private MypageService mypageService;
	   
		// 가계부 지출 내역
		@RequestMapping("expenditureListVue.do")
		@ResponseBody
		public Map<String, Object> expenditureListVue(Model model, @RequestParam Map<String, Object> paramMap, 
				HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
			
			logger.info("   - paramMap : " + paramMap);
			//String title = (String) paramMap.get("title");
			String mn_use_dvs = (String) paramMap.get("mn_use_dvs");
			String from_date = (String) paramMap.get("from_date");
			String to_date = (String) paramMap.get("to_date");
			String loginId = (String) paramMap.get("loginId");
			
			//int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
		    //int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		    //int pageIndex = (currentPage - 1) * pageSize;
			
			//paramMap.put("pageIndex", pageIndex);
			//paramMap.put("pageSize", pageSize);
			//paramMap.put("title", title);
			
			// 공지사항 목록 조회
			List<MypageModel> expenditureList = mypageService.expenditureList(paramMap);		
			// 목록 수 추출해서 보내기
			//int noticeCnt = mypageService.gagevueAllList(paramMap);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("expenditureList", expenditureList); // success 용어 담기 
			//resultMap.put("noticeCnt", noticeCnt); // 리턴 값 해쉬에 담기 
		    //resultMap.put("pageSize", pageSize);
		    //resultMap.put("currentPage",currentPage);
		    
		    return resultMap;
		}	
}