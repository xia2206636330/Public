package Dao.entity;
/**
 * java web Ӧ��ʵ�����ݿ����
 * ����һ���û���Ϣ��ʵ����
 * @author �Ķ���
 *
 */
public class User {
	/**
	 * �û����
	 */
	private int userid;
	
	/**
	 * �û��˺�
	 */
	private String zhanghao;
	
	
	
	
	/**
	 * �û�����
	 */
	private String  name;
	
	
	
	
	/**
	 * �û�����
	 */
	private String password;
	
	
	
	
	/**
	 * �û�״̬
	 */
	private int zhuangtai;
	
	
	
	/**
	 * �û����
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
