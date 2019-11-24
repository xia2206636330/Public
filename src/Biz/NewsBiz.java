package Biz;

import java.util.List;

import Dao.entity.News;

/**
 *  业务逻辑层  新闻内容接口
 * @author 夏冬旺
 *
 */
public interface NewsBiz {
	
	/**
	 * 添加信息
	 * @param news
	 * @return
	 */
	public int addNews(News news);
	
	
	
	/**
	 * 获取新闻信息数量
	 * @param typeid
	 * @return
	 */
	public int getCount(Integer typeid);
	
	
	/**
	 * 查询每页信息集合
	 * @param currentpage
	 * @param pagesize
	 * @param typeid
	 * @return
	 */
	public List<News> getByPage(int currentpage,int pagesize,Integer typeid);

}
