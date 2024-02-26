package kr.happyjob.study.service.mypage;

import java.text.SimpleDateFormat;
import java.util.*;

import kr.happyjob.study.vo.login.UserVO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.mypage.MypageMapper;

import kr.happyjob.study.vo.mypage.MypageModel;
import kr.happyjob.study.vo.mypage.MypageUserInfoModel;

@Service
public class MypageService {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();

    @Autowired
    private MypageMapper mypageMapper;

    // 가계뷰 지출입 내역 조회
    public List<MypageModel> expenditureList(Map<String, Object> paramMap) throws Exception {
        return mypageMapper.expenditureList(paramMap);
    }
    
    // 마이페이지 회원정보 조회
    public List<MypageUserInfoModel> getMypageUserInfo(Map<String, Object> paramMap) throws Exception {
    	return mypageMapper.getMypageUserInfo(paramMap);
    }

    public Map<String, Object> cardCashStatisticsTest(Map<String, Object> paramMap) throws Exception {
        List<MypageModel> cardList = mypageMapper.cardCashStatisticsTest1(paramMap);
        List<MypageModel> cashList = mypageMapper.cardCashStatisticsTest2(paramMap);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cardList", cardList);
        resultMap.put("cashList", cashList);
        return resultMap;
        /*
        logger.info(list1.size());
        logger.info(list2.size());
        Map<String, Object> testMap = new HashMap<>();

        MypageModel testVO = new MypageModel();
        List<MypageModel> testList = new ArrayList<MypageModel>();
        testVO.setMn_upd_dtm("2024-01-01");
        testVO.setSum_amount(10000);
        testList.add(testVO);
        logger.info(testList.get(0).getMn_upd_dtm());
        logger.info(testList.get(0).getSum_amount());
        logger.info("for start");
        int testInt = 0;
        if (list1.size() > list2.size()) testInt = list2.size();
        if (list2.size() > list1.size()) testInt = list1.size();
        for (int i = 0; i < testInt; i++) {
            String test1 = list1.get(i).getMn_upd_dtm();
            logger.info(list1.get(i).getMn_upd_dtm());
            logger.info(list1.get(i).getSum_amount());

            if (list1.get(i).getMn_upd_dtm() == list2.get(i).getMn_upd_dtm()) {
                testVO.setMn_upd_dtm(list1.get(i).getMn_upd_dtm());
                testVO.setMn_amount(list1.get(i).getSum_amount());
                testVO.setSum_amount(list2.get(i).getSum_amount());
            } else {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = formatter.parse(list1.get(i).getMn_upd_dtm());
                Date d2 = formatter.parse(list2.get(i).getMn_upd_dtm());
                logger.info(d1);
                logger.info(d2);
                logger.info(d1.after(d2));
                testVO.setMn_upd_dtm(list2.get(i).getMn_upd_dtm());
                testVO.setMn_amount(0);
                testVO.setSum_amount(list2.get(i).getSum_amount());
            }
            testList.add(testVO);
            logger.info("result" + i);
            logger.info(testList.get(i).getMn_upd_dtm());
            logger.info(testList.get(i).getMn_amount());
            logger.info(testList.get(i).getSum_amount());
        }
*/
    }

    public void updateUser(UserVO vo) throws Exception {
        mypageMapper.updateUser(vo);
    }
    public void updateUserGoal(Map<String, Object> paramMap) throws Exception {
    	mypageMapper.updateUserGoal(paramMap);
    }

    public void updatePw(Map<String, Object> paramMap) throws Exception{
        mypageMapper.updatePw(paramMap);
    }
}