package nutil;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ҳ��ѯ�Ĺ�����
 * @author �Ķ���
 *
 */
public class passageQuery {
	/**
	 * �ܹ���ʾ��Ϣ��
	 */
	public int totalrows;
	
	
	/**
	 * ÿҳ��ʾ��Ϣ��
	 */
	public int pagesize = 3;
	
	/**
	 * ��ǰҳ��
	 */
	public int currentpage;
	
	
	/**
	 * �ܹ���ҳ��
	 */
	public int countpage;
	
	/**
	 * ÿҳչʾ��Ϣ�ļ���
	 */
	public List list = new ArrayList();
	
	
	//����get   set  ����
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	//���з�ҳ���㣬�ֶ���ҳ��
	public int getCountpage() {
		countpage = totalrows%pagesize == 0? totalrows/pagesize:totalrows/pagesize+1;
		
		return countpage;
	}

//	public void setCountpage(int countpage) {
//		this.countpage = countpage;
//	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}	
