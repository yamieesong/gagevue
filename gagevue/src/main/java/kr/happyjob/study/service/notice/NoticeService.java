package kr.happyjob.study.service.notice;

import java.util.List;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.login.ListUsrMnuAtrtMapper;
import kr.happyjob.study.vo.notice.NoticeModel;
import kr.happyjob.study.repository.notice.NoticeMapper;

@Service
public class NoticeService {
	
	@Autowired
	private ListUsrMnuAtrtMapper listUsrMnuAtrtMapper;
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	
	public List<NoticeModel> noticeList(Map<String, Object> paramMap) throws Exception{

		return noticeMapper.noticeList(paramMap);
	}

	public int noticeCnt(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeCnt(paramMap);
	}
	
	public NoticeModel noticeDetail(Map<String, Object> paramMap) throws Exception {

		return noticeMapper.noticeDetail(paramMap);
	}

	public int insertNotice(Map<String, Object> paramMap) throws Exception {

		return noticeMapper.insertNotice(paramMap);
	}

	public int updateNotice(Map<String, Object> paramMap) throws Exception {

		return noticeMapper.updateNotice(paramMap);
	}

	public int deleteNotice(Map<String, Object> paramMap) throws Exception {

		return noticeMapper.deleteNotice(paramMap);
	}
	
}
