package Dao.entity;

import java.util.Date;

import javax.xml.crypto.Data;

/**
 * Java web Ӧ��ʵ�����ݿ����
 * ����һ��������Ϣ��ʵ����
 * @author �Ķ���
 *
 */
public class News {
	/**
	 * ����������
	 * @author �Ķ���
	 *
	 */
	
	
	
	/**
	 * ����id
	 */
	private int passageid;
	
	/**
	 * ��������
	 */
	private int typeid;
	
	

	/**
	 * ���ű���
	 */
	
	private String title;
	
	
	
	/**
	 * ��������
	 */
	private String  neirong;
	
	
	
	/**
	 * ��������
	 */
	private String writer;
	
	/**
	 * ���ŷ���ʱ��
	 */
	private Date newstime;


	/**
	 * ������Ƭ
	 */
	private String nimg;

	//����get  set  ����
	public int getPassageid() {
		return passageid;
	}

	public void setPassageid(int passageid) {
		this.passageid = passageid;
	}
	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getNewstime() {
		return newstime;
	}

	public void setNewstime(Date newstime) {
		this.newstime = newstime;
	}
	
	public String getNimg() {
		return nimg;
	}

	public void setNimg(String nimg) {
		this.nimg = nimg;
	}
	
}
