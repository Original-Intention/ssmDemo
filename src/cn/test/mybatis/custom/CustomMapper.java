package cn.test.mybatis.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.test.mybatis.vo.UserCustomVO;

public interface CustomMapper {
	/**
	 * @param id 主键
	 * @date 2019-4-3 19:56:13
	 * @return 返回包装类POJO
	 */
	public UserCustomVO findUserCustomVOById(int id);
	/**
	 * @param username 用户名
	 * @date 2019-3-26 16:22:03
	 * @return 数量
	 */
	public int findCountByUserCustomVO(UserCustomVO usercustom);
	
}
