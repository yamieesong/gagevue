package kr.happyjob.study.repository.menu;

import kr.happyjob.study.vo.menu.MenuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {
    public List<MenuVo> menuList(Map<String,Object> param) throws Exception;
    public int menuListCnt() throws Exception;
    public List<MenuVo> tnUsrMnuAtrt(Map<String,Object> param) throws Exception;
    public int tnUsrMnuAtrtCnt() throws Exception;

}
