package cn.test.mybatis.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.test.mybatis.vo.UserCustomVO;

public interface CustomMapper {
	/**
	 * @param id ����
	 * @date 2019-4-3 19:56:13
	 * @return ���ذ�װ��POJO
	 */
	public UserCustomVO findUserCustomVOById(int id);
	/**
	 * @param username �û���
	 * @date 2019-3-26 16:22:03
	 * @return ����
	 */
	public int findCountByUserCustomVO(UserCustomVO usercustom);
	
}
