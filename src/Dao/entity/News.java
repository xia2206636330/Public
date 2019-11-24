package Dao.entity;

import java.util.Date;

import javax.xml.crypto.Data;

/**
 * Java web 应用实现数据库访问
 * 这是一个新闻信息的实体类
 * @author 夏冬旺
 *
 */
public class News {
	/**
	 * 新闻内容类
	 * @author 夏冬旺
	 *
	 */
	
	
	
	/**
	 * 新闻id
	 */
	private int passageid;
	
	/**
	 * 新闻类型
	 */
	private int typeid;
	
	

	/**
	 * 新闻标题
	 */
	
	private String title;
	
	
	
	/**
	 * 新闻内容
	 */
	private String  neirong;
	
	
	
	/**
	 * 新闻作者
	 */
	private String writer;
	
	/**
	 * 新闻发布时间
	 */
	private Date newstime;


	/**
	 * 新闻照片
	 */
	private String nimg;

	//生成get  set  方法
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
