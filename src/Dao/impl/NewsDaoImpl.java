package Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import Dao.BaseDao;
import Dao.NewsDao;
import Dao.entity.News;
/**
 * 新闻内容实现类
 * @author 夏冬旺
 *
 */
public class NewsDaoImpl implements NewsDao {
	/**
	 * 查询全部新闻内容 
	 */
	@Override
	public List<News> findAll() {
		String sql = "select * from news";
		ResultSet rs = BaseDao.query(sql, null);
		List<News> news = new ArrayList<News>();
		try {
			while(rs.next()){
				News n = new News();
				n.setPassageid(rs.getInt("passageid"));
				n.setTypeid(rs.getInt("typeid"));
				n.setTitle(rs.getString("title"));
				n.setNeirong(rs.getString("neirong"));
				n.setWriter(rs.getString("writer"));
				n.setNewstime(rs.getDate("newstime"));
				n.setNimg(rs.getString("nimg"));
				//将数据添加到集合
				news.add(n);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			try {
				BaseDao.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		return news;
	}

	@Override
	public int addNews(News news) {
		
		String sql ="insert into news(passageid,typeid,title,neirong,writer,newstime,nimg) values(?,?,?,?,?,?,?)";
		return BaseDao.update(sql, new Object[]{news.getPassageid(),news.getTypeid(),news.getTitle(),news.getNeirong(),news.getWriter(),news.getNewstime(),news.getNimg()});
	}

	@Override
	public int getCount(Integer typeid) {
		int result  = 0;
		String sql = "select count(1) from news";
		Object[] params = null;
		//判断是否为空？如果typeid有值，则查询sql语句，如果没有值，则查询全部
		if(typeid!=null){
			sql +="where typeid = ?  ";
			params = new Object[]{typeid};
		}
		//接收结果集
		ResultSet rs = BaseDao.query(sql, params);
		try {
		//遍历结果集
			if (rs.next()) {
		//取出结果
				result = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		//返回一个结果
		return result;
	}

	@Override
	public List<News> getByPage(int currentpage, int pagesize, Integer typeid) {
		String sql = "select  *  from  news ";
		Object[] params = null;
		if (typeid!=null) {
			sql += " where typeid = ? ";
			params = new Object[]{typeid};
			
		}
		int index = (currentpage-1)*pagesize;
		sql += " limit " + index + " , " + pagesize;
		ResultSet rs = BaseDao.query(sql, params);
		List<News> news = new ArrayList<News>();
		try {
			while(rs.next()){
				News n = new News();
				n.setPassageid(rs.getInt("passageid"));
				n.setTypeid(rs.getInt("typeid"));
				n.setTitle(rs.getString("title"));
				n.setNeirong(rs.getString("neirong"));
				n.setWriter(rs.getString("writer"));
				n.setNewstime(rs.getDate("newstime"));
				n.setNimg(rs.getString("nimg"));
				//将数据添加到集合
				news.add(n);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			try {
				BaseDao.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		return news;	
	}
}
