package Biz.impl;

import java.util.Date;
import java.util.List;

import Biz.NewsBiz;
import Dao.NewsDao;
import Dao.entity.News;
import Dao.impl.NewsDaoImpl;
/**
 * 新闻内容实现类
 * @author 夏冬旺
 *
 */
public class NewsBizimpl implements NewsBiz {
	NewsDao nd = new NewsDaoImpl();
	/**
	 * 添加信息
	 */
	@Override
	public int addNews(News news) {
		
		news.setNewstime(new Date());
		return nd.addNews(news);
	}

	@Override
	public int getCount(Integer typeid) {
		
		return nd.getCount(typeid);
	}

	@Override
	public List<News> getByPage(int currentpage, int pagesize, Integer typeid) {
	
		return nd.getByPage(currentpage, pagesize, typeid);
	}

}
