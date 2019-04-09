package cn.test.mybatis.vo;

import java.util.Date;

import cn.test.mybatis.custom.Custom;

public class UserCustomVO {
    private Integer id;
    private String username;// �û�����
    private String sex;// �Ա�
    private Date birthday;// ����
    private String address;// ��ַ
	private Custom custom;
	
    public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
