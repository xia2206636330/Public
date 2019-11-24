package Dao.entity;
/**
 * Java web应用实现数据库访问
 * 这是一个关于新闻类型的实体类
 * @author 夏冬旺
 *
 */
public class Type {
	
	
	
	/**
	 * 新闻类型id
	 */	
	private int typeid;
	
	
	
	
	
	
	/**
	 * 新闻类型名称
	 */
	private String typename;
	
	
	
	
	

	//生成get set 方法
	public int getTypeid() {
		return typeid;
	}


	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}


	public String getTypename() {
		return typename;
	}


	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	
	
	
	
}
