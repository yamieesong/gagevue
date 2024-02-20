package kr.happyjob.study.controller.auth;

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

import kr.happyjob.study.service.auth.AuthService;
import kr.happyjob.study.service.login.ListUsrChildMnuAtrtService;
import kr.happyjob.study.service.login.ListUsrMnuAtrtService;
import kr.happyjob.study.service.login.LoginProcService;
import kr.happyjob.study.service.login.LoginService;
import kr.happyjob.study.vo.login.LoginVO;
import kr.happyjob.study.vo.login.UserVO;
import kr.happyjob.study.vo.login.LgnInfoModel;
import kr.happyjob.study.vo.login.UsrMnuAtrtModel;
import kr.happyjob.study.vo.login.UsrMnuChildAtrtModel;

@Controller
public class AuthController {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@Autowired
	private AuthService authservice;

	/**
	 * 회원가입 - 아이디 중복 확인
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public int checkId(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("ID중복 확인 요청 ::: ID " + paramMap.get("loginId"));
		int rst = 0;
		try {
			rst = authservice.checkId(paramMap);
			logger.info("ID중복 확인 결과 ::: ID " + paramMap.get("loginId") + " (" + rst + ")");
		} catch(Exception e) {
			e.printStackTrace();
			return rst;
		}
		
		return rst;
	}
	
	/**
	 * 회원가입 - 회원정보 INSERT
	 * @param model
	 * @param paramMap (joinNm, joinHp, joinMail, joinId, joinPw, joinPushYn)
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rgstMbrGgv.do")
	@ResponseBody
	public int rgstMbrGgv(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("회원가입 요청 ::: ID " + paramMap.get("joinId"));
		logger.info("회원가입 요청 ::: data " + paramMap.toString());
		int rst = 0;
		int mbrMngNo = 0;
		int seqRst = 0;
		try {
			// 회원관리번호 채번
			mbrMngNo = authservice.mbrMngNoSeq();
			if(mbrMngNo > 0) {
				paramMap.put("mbrMngNo", mbrMngNo);		
			} else {
				logger.info("회원관리번호 채번 오류");
				return 0;
			}
			// 회원정보 INSERT
			rst = authservice.insertRgstMbr(paramMap);
			logger.info("회원가입 성공 ::: ID " + paramMap.get("joinId"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// tb_seq UPDATE
			seqRst = authservice.mbrMngNoSeqAdd(mbrMngNo);
			if(seqRst < 1) {
				logger.error("TB_SEQ 회원관리번호 업데이트 오류");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rst;
	}
	
	
	/**
	 * 아이디/비밀번호 찾기 - 인증번호 발송
	 * @param model
	 * @param paramMap (authHp, code)
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/authSmsSend.do")
	@ResponseBody
	public int authSmsSend(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		int rst = 0;
		
		return rst;		
	}
}