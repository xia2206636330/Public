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
 * ��������ʵ����
 * @author �Ķ���
 *
 */
public class NewsDaoImpl implements NewsDao {
	/**
	 * ��ѯȫ���������� 
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
				//��������ӵ�����
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
		//�ж��Ƿ�Ϊ�գ����typeid��ֵ�����ѯsql��䣬���û��ֵ�����ѯȫ��
		if(typeid!=null){
			sql +="where typeid = ?  ";
			params = new Object[]{typeid};
		}
		//���ս����
		ResultSet rs = BaseDao.query(sql, params);
		try {
		//���������
			if (rs.next()) {
		//ȡ�����
				result = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		//����һ�����
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
				//��������ӵ�����
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
