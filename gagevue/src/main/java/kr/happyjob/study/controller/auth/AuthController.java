package kr.happyjob.study.controller.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kr.happyjob.study.service.auth.AuthService;

@Controller
public class AuthController {
	@Autowired
	private AuthService authservice;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	String rqstm = " 요청 ::: ";
	String infom = " 정보 ::: ";
	String rstm = " 결과 ::: ";
	String errm1= " 에러 ::: ";
	String errm2= " 오류 ::: ";
	String scssm= " 성공 ::: ";
	String fm = " 실패 ::: "	;
	String scssem = "SUCCESS";
	String expiem = "EXPIRED";
	String nonem = "NON";
	String fem = "FAIL";

	/**
	 * 회원가입 - ID중복확인
	 * 
	 * @version 1.0.1
	 * @author hyoung
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
	public int checkId(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		String lgnm = "[ID중복확인]"; 
		logger.info(lgnm + rqstm + paramMap.get("loginId"));
		int rst = 0;
		try {
			rst = authservice.checkId(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			return rst;
		}
		logger.info(lgnm + rstm  + paramMap.get("loginId") + " (" + rst + ")");
		return rst;
	}

	/**
	 * 회원가입 - 회원정보 INSERT
	 * 
	 * @version 1.0.1
	 * @author hyoung
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
	public int rgstMbrGgv(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		String lgnm = "[회원가입]";
		logger.info(lgnm + rqstm + paramMap.toString());
		int rst = 0;
		int mbrMngNo = 0;
		int seqRst = 0;
		try {
			mbrMngNo = authservice.mbrMngNoSeq();
			if (mbrMngNo > 0) {
				paramMap.put("mbrMngNo", mbrMngNo);
			} else {
				logger.info(lgnm + errm2 + paramMap.get("joinId"));
				return 0;
			}
			rst = authservice.insertRgstMbr(paramMap);
			logger.info(lgnm + scssm + paramMap.get("joinId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			seqRst = authservice.mbrMngNoSeqAdd(mbrMngNo);
			if (seqRst < 1) {
				logger.info(lgnm + errm2 + "(TB_SEQ 회원관리번호 업데이트) " + paramMap.get("joinId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(lgnm + rstm  + paramMap.get("joinId") + " (" + rst + ")");
		return rst;
	}

	/**
	 * 회원조회
	 * 
	 * @version 1.0.1
	 * @author hyoung
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/mbrChekMail.do")
	@ResponseBody
	public Map<String, Object> mbrChekMail(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		String lgnm = "[회원조회]";
		logger.info(lgnm + rqstm + paramMap.get("mbr_mail"));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> mbrMap = new HashMap<>();
		try {
			mbrMap = authservice.selectMbrMail(paramMap);
			if (mbrMap != null) {
				logger.info(lgnm + scssm + mbrMap.get("mbr_no"));
				resultMap.put("result", scssem);
				resultMap.put("mbr_no", mbrMap.get("mbr_no"));
			} else {
				logger.info(lgnm + fm + paramMap.get("mbr_mail"));
				resultMap.put("result", nonem);
				return resultMap;
			}
		} catch (Exception e) {
			logger.info(lgnm + errm1 + paramMap.get("mbr_mail") +  e.getMessage());
		}
		return resultMap;
	}

	/**
	 * 아이디/비밀번호 찾기 - 토큰생성
	 * 
	 * @version 1.0.1
	 * @author hyoung
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/token.do")
	@ResponseBody
	public Map<String, Object> mbrToken(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		String lgnm = "[토큰생성]";
		logger.info(lgnm + rqstm + paramMap.get("mbr_mail"));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int rst = 0;
		Random random = new Random();
		String mailCODE = String.valueOf(random.nextInt(9000) + 1000);
		try {
			String verificationToken = UUID.randomUUID().toString().substring(0, 30);

			Map<String, Object> tokenMap = new HashMap<String, Object>();
			tokenMap.put("token", verificationToken);
			tokenMap.put("mailCODE", mailCODE);
			tokenMap.put("mbr_mail", paramMap.get("mbr_mail"));
			rst = authservice.uuidMbrUpdate(tokenMap);
			if(rst <= 0) {
				logger.info(lgnm + fm + paramMap.get("mbr_mail"));
				resultMap.put("result", fem);
				return resultMap;
			}
			if ("ID".equals(paramMap.get("authtype"))) {
				resultMap.put("mailURL", "/auth/" + verificationToken + paramMap.get("authtype")
						+ paramMap.get("mbr_no"));
			}
			if ("PW".equals(paramMap.get("authtype"))) {
				resultMap.put("mailURL", "/findPW/" + verificationToken
						+ paramMap.get("authtype") + paramMap.get("mbr_no"));
			}
			resultMap.put("mailCODE", mailCODE);
			resultMap.put("result", scssem);
		} catch (Exception e) {
			logger.info(lgnm + errm1 + paramMap.get("mbr_mail") +  e.getMessage());
		}
		logger.info(lgnm + infom + paramMap.get("mbr_mail") + " " + resultMap.get("mailURL") + " " + mailCODE);
		logger.info(lgnm + rstm  + paramMap.get("mbr_mail") + " (" + rst + ")");
		return resultMap;
	}

	/**
	 * 아이디/비밀번호 찾기 - 인증링크
	 * 
	 * @version 1.0.1
	 * @author hyoung
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/authMbr.do")
	@ResponseBody
	public Map<String, Object> uuidMbr(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> valMap = new HashMap<String, Object>();
		String lgnm = "[인증링크]";
		String dvs = "";
		String orgId = "";
		logger.info(lgnm + rqstm + paramMap.toString());
		int rst = 0;
		String param = (String) paramMap.get("token");
		Map<String, Object> tokenInfo = new HashMap<String, Object>();
		tokenInfo.put("token", param.substring(0, 30)); 	// 본인인증UUID값
		tokenInfo.put("type", param.substring(30, 32)); 	// 본인인증유형
		tokenInfo.put("mbrNo", param.substring(32)); 		// 회원관리번호
		if (param.length() <= 32) {
			resultMap.put("result", nonem);
			return resultMap;
		}
		try {
			valMap = authservice.checkMbrAuthRst(tokenInfo);
			orgId = (String) valMap.get("mbr_id");
			if ("S".equals(valMap.get("mbr_auth_rst"))) {
				resultMap.put("result", expiem);
				return resultMap;
			} else if ("C".equals(valMap.get("mbr_auth_rst")) && "ID".equals(tokenInfo.get("type"))) {
				rst = authservice.updateToken(tokenInfo);
				if (rst == 1) {
					dvs = "아이디확인 성공 - ";
					resultMap.put("result", scssem);
					resultMap.put("mbrID", orgId);
					resultMap.put("maskingID", orgId.substring(0, 3) + "**");
					resultMap.put("mbr_mail", valMap.get("mbr_mail"));
				}
			} else if ("C".equals(valMap.get("mbr_auth_rst")) && "PW".equals(tokenInfo.get("type"))) {
				dvs = "비밀번호변경 페이지 진입 - ";
				resultMap.put("result", scssem);
				resultMap.put("mbrID", orgId);
				resultMap.put("maskingID", orgId.substring(0, 3) + "**");
				resultMap.put("mbr_mail", valMap.get("mbr_mail"));
				resultMap.put("mbr_no", tokenInfo.get("mbrNo"));
			} else {
				resultMap.put("result", nonem);
				return resultMap;
			}
		} catch (Exception e) {
			logger.info(lgnm + errm1 + param.substring(32) +  e.getMessage());
		}
		logger.info(lgnm + scssm + dvs + valMap.get("mbr_mail") + " " + orgId);
		return resultMap;
	}

	/**
	 * 비밀번호 변경
	 * 
	 * @version 1.0.1
	 * @author hyoung
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPW.do")
	@ResponseBody
	public int modifyPW(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		String lgnm = "[비밀번호 변경]";
		logger.info(lgnm + rqstm + paramMap.get("mbr_no"));
		int rst = 0;
		try {
			rst = authservice.updatePW(paramMap);
			if (rst < 1) {
				logger.info(lgnm + fm + paramMap.get("mbr_no"));
				return rst;
			}
		} catch (Exception e) {
			logger.info(lgnm + errm1 + paramMap.get("mbr_no") +  e.getMessage());
		}
		logger.info(lgnm + rstm  + paramMap.get("mbr_no") + " (" + rst + ")");
		return rst;
	}

}