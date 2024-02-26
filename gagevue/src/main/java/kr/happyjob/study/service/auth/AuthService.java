package kr.happyjob.study.service.auth;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.happyjob.study.repository.auth.AuthMapper;

@Service
public class AuthService {
	@Autowired
	private AuthMapper authMapper;

	private final Logger logger = LogManager.getLogger(this.getClass());

	/** ID중복확인 */
	public int checkId(Map<String, Object> paramMap) {
		return authMapper.checkId(paramMap);
	}

	/** 회원가입 - 회원관리번호, 목표관리번호 채번 */
	public Map<String, Object> mbrMngNoSeq() {
		return authMapper.mbrMngNoSeq();
	}

	/**
	 * 회원가입 - 회원정보 INSERT
	 * : 회원관리(tb_userinfo), 목표관리(tb_goal) 중 하나라도 실패할 경우 롤백 처리.
	 * 
	 * @version 1.0.1
	 * @author hyoung
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public int insertMbr(Map<String, Object> paramMap) throws Exception {
		int rst = 0;
		try {
			int mbrRst = 0;
			mbrRst = authMapper.insertRgstMbr(paramMap);
			int goalRst = 0;
			goalRst = authMapper.insertGoal(paramMap);

			if (mbrRst == 1 && goalRst == 1) {
				rst = 1;
			} else {
				logger.error("[회원가입] 에러 ::: authservice.insertRgstMbr INSERT ERR!!!");
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rst;
	}

	/** 회원가입 - 회원관리번호, 목표관리번호 업데이트 */
	public int mbrMngNoSeqAdd(Map<String, Object> paramMap) {
		return authMapper.mbrMngNoSeqAdd(paramMap);
	}

	/** 토큰생성 - 토큰생성(C 발급완료, S 인증완료) */
	public int uuidMbrUpdate(Map<String, Object> paramMap) {
		return authMapper.uuidMbrUpdate(paramMap);
	}

	/** 회원조회 - 인증상태조회 */
	public Map<String, Object> checkMbrAuthRst(Map<String, Object> paramMap) {
		return authMapper.checkMbrAuthRst(paramMap);
	}

	/** 회원조회 */
	public Map<String, Object> selectMbrMail(Map<String, Object> paramMap) {
		return authMapper.selectMbrMail(paramMap);
	}

	/** 회원조회 - 인증완료 */
	public int updateToken(Map<String, Object> paramMap) {
		return authMapper.updateToken(paramMap);
	}

	/** 비밀번호 변경 */
	public int updatePW(Map<String, Object> paramMap) {
		return authMapper.updatePW(paramMap);
	}

}
