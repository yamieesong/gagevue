package kr.happyjob.study.controller.mypage;

import kr.happyjob.study.service.mypage.MypageService;
import kr.happyjob.study.vo.login.UserVO;
import kr.happyjob.study.vo.mypage.MypageModel;
import kr.happyjob.study.vo.mypage.MypageUserInfoModel;
import org.apache.catalina.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String typeChk = (String) paramMap.get("typeChk");
        String mn_use_dvs = (String) paramMap.get("mn_use_dvs");
        String from_date = (String) paramMap.get("from_date");
        String to_date = (String) paramMap.get("to_date");
        String loginId = (String) paramMap.get("loginId");
        String menuName = (String) paramMap.get("menuName");

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

        if ("CardCashStatistics".equals(menuName)) {
            Map<String, Object> resultMap2 = mypageService.cardCashStatisticsTest(paramMap);
            resultMap.put("cardList", resultMap2.get("cardList"));
            resultMap.put("cashList", resultMap2.get("cashList"));
        }

        return resultMap;
    }

    @RequestMapping("updateUser.do")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestParam Map<String, Object> paramMap) throws Exception {
        logger.info("updateUser start");
        logger.info("   - paramMap : " + paramMap);

        UserVO vo = new UserVO();
        vo.setLoginId((String) paramMap.get("loginId"));
        vo.setHp((String) paramMap.get("hp"));
        vo.setEmail((String) paramMap.get("email"));
        vo.setPassword((String) paramMap.get("pw"));
        vo.setMbrYn((String) paramMap.get("alarmYn"));

        try {
            mypageService.updateUser(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> resultmap = new HashMap<>();
        return resultmap;
    }
    
    @RequestMapping("updateUserGoal.do")
    @ResponseBody
    public Map<String, Object> updateUserGoal(@RequestParam Map<String, Object> paramMap) throws Exception {
    	logger.info("updateUser start");
    	logger.info("   - paramMap : " + paramMap);
        String goal = (String) paramMap.get("goal");
        String mbr_no = (String) paramMap.get("mbr_no");
        String goal_yr = (String) paramMap.get("goal_yr");
        String goal_m = (String) paramMap.get("goal_m");
    	
    	UserVO vo = new UserVO();    	
    	vo.setGoal((String) paramMap.get("goal"));
    	
    	try {
    		mypageService.updateUser(vo);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	Map<String, Object> resultmap = new HashMap<>();
    	return resultmap;
    }
    
    // 마이페이지 회원정보 조회
    @RequestMapping("getMypageUserInfo.do")
    @ResponseBody
    public Map<String, Object> getMypageUserInfo(Model model, @RequestParam Map<String, Object> paramMap,
    		HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
    	logger.info("   - paramMap : " + paramMap);
    	String loginId = (String) paramMap.get("loginId");
    	String goal_yr = (String) paramMap.get("goal_yr");
    	String goal_m = (String) paramMap.get("goal_m");
    	
    	//int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
    	//int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
    	//int pageIndex = (currentPage - 1) * pageSize;
    	
    	//paramMap.put("pageIndex", pageIndex);
    	//paramMap.put("pageSize", pageSize);
    	//paramMap.put("title", title);
    	
    	// 공지사항 목록 조회
    	List<MypageUserInfoModel> getMypageUserInfo = mypageService.getMypageUserInfo(paramMap);
    	
    	// 목록 수 추출해서 보내기
    	//int noticeCnt = mypageService.gagevueAllList(paramMap);
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("getMypageUserInfo", getMypageUserInfo); // success 용어 담기
    	//resultMap.put("noticeCnt", noticeCnt); // 리턴 값 해쉬에 담기
    	//resultMap.put("pageSize", pageSize);
    	//resultMap.put("currentPage",currentPage);
    	
    	return resultMap;
    }
}