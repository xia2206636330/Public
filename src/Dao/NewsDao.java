package Dao;

import java.util.List;

import Dao.entity.News;

public interface NewsDao {
	/**
	 * ��ȡ����������Ϣ
	 */
	public List<News> findAll(); 
	
	
	
	/**
	 * �������
	 * @param news
	 * @return
	 */
	public int addNews(News news);	
	
	/**
	 * ��ȡ������Ϣ����
	 * @param typeid
	 * @return
	 */
	//�ö�������û����int intĬ��ֵΪ0��integerĬ��ֵΪnull
	public int getCount(Integer typeid);
	
	
	/**
	 * ��ѯÿҳ��Ϣ����
	 * @param currentpage ��ǰҳ��
	 * @param pagesize    ÿҳ��ʾ��Ϣ��
	 * @param typeid       ��������
	 * @return
	 */
	public List<News> getByPage(int currentpage,int pagesize,Integer typeid);
}
