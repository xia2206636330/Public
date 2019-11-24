package Dao;

import java.util.List;

import Dao.entity.News;

public interface NewsDao {
	/**
	 * 获取新闻所有信息
	 */
	public List<News> findAll(); 
	
	
	
	/**
	 * 添加新闻
	 * @param news
	 * @return
	 */
	public int addNews(News news);	
	
	/**
	 * 获取新闻信息数量
	 * @param typeid
	 * @return
	 */
	//用对象类型没有用int int默认值为0，integer默认值为null
	public int getCount(Integer typeid);
	
	
	/**
	 * 查询每页信息集合
	 * @param currentpage 当前页码
	 * @param pagesize    每页显示信息数
	 * @param typeid       新闻类型
	 * @return
	 */
	public List<News> getByPage(int currentpage,int pagesize,Integer typeid);
}
