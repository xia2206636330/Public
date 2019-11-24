package Biz;

import java.util.List;

import Dao.entity.News;

/**
 *  ҵ���߼���  �������ݽӿ�
 * @author �Ķ���
 *
 */
public interface NewsBiz {
	
	/**
	 * �����Ϣ
	 * @param news
	 * @return
	 */
	public int addNews(News news);
	
	
	
	/**
	 * ��ȡ������Ϣ����
	 * @param typeid
	 * @return
	 */
	public int getCount(Integer typeid);
	
	
	/**
	 * ��ѯÿҳ��Ϣ����
	 * @param currentpage
	 * @param pagesize
	 * @param typeid
	 * @return
	 */
	public List<News> getByPage(int currentpage,int pagesize,Integer typeid);

}
