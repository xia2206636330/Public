package Biz;

import Dao.entity.User;

/**
 *  业务逻辑层  新闻用户接口
 * @author 夏冬旺
 *
 */
public interface UserBiz {
	/**
	 * 查询用户
	 * @param zhanghao
	 * @param password
	 * @return
	 */
	public User login(String zhanghao, String password);
}
