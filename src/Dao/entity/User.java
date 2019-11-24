package Dao.entity;
/**
 * java web 应用实现数据库访问
 * 这是一个用户信息的实体类
 * @author 夏冬旺
 *
 */
public class User {
	/**
	 * 用户编号
	 */
	private int userid;
	
	/**
	 * 用户账号
	 */
	private String zhanghao;
	
	
	
	
	/**
	 * 用户姓名
	 */
	private String  name;
	
	
	
	
	/**
	 * 用户密码
	 */
	private String password;
	
	
	
	
	/**
	 * 用户状态
	 */
	private int zhuangtai;
	
	
	
	/**
	 * 用户身份
	 */
	private int shenfen;
	
	
	
	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public String getZhanghao() {
		return zhanghao;
	}



	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getZhuangtai() {
		return zhuangtai;
	}



	public void setZhuangtai(int zhuangtai) {
		this.zhuangtai = zhuangtai;
	}



	public int getShenfen() {
		return shenfen;
	}



	public void setShenfen(int shenfen) {
		this.shenfen = shenfen;
	}
}
