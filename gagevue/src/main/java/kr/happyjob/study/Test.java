package kr.happyjob.study;

import kr.happyjob.study.repository.mypage.MypageMapper;
import kr.happyjob.study.vo.mypage.MypageModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    @Autowired
    static MypageMapper mypageMapper;

    public static void main(String[] args) {


        System.out.println("Hello, world!");
        Date today = new Date();
        String dateTest = "2024-01-01";
        SimpleDateFormat test1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(test1.format(today));
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("mn_use_dvs", "1");
        paramMap.put("from_date", "2024-02-01");
        paramMap.put("to_date", "2024-02-29");
        paramMap.put("loginId", "wallmart");
        paramMap.put("typeChk", "pay");

//        List<MypageModel> testList = mypageMapper.expenditureList(paramMap);
    }
}
