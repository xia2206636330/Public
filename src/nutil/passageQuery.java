package nutil;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询的工具类
 * @author 夏冬旺
 *
 */
public class passageQuery {
	/**
	 * 总共显示信息数
	 */
	public int totalrows;
	
	
	/**
	 * 每页显示信息数
	 */
	public int pagesize = 3;
	
	/**
	 * 当前页码
	 */
	public int currentpage;
	
	
	/**
	 * 总共分页数
	 */
	public int countpage;
	
	/**
	 * 每页展示信息的集合
	 */
	public List list = new ArrayList();
	
	
	//生成get   set  方法
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
	//进行分页计算，分多少页！
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
