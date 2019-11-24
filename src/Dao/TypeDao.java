package Dao;

import java.util.List;

import Dao.entity.Type;



/**
 * 新闻类型数据访问层接口
 * @author 夏冬旺
 *
 */
public interface TypeDao {
	/**
	 * 增加数据
	 */
	public int addType(String typename);
	
	
	/**
	 * 修改数据
	 */
	public int updateType(Type type);
	
	
	/**
	 * 删除接口
	 */
	public int daleteType(int typeid);
	
	/**
	 * 获取所有的新闻类型信息
	 */
	public List<Type> findAll();
	
	
	/**
	 * 根据名称来查询单个类型新闻
	 */
	public Type findByName(String typename);
}
