package Dao;

import Dao.entity.User;

/**
 * 这是用户表的一个接口
 * @author 夏冬旺
 *
 */
public interface UserDao {
	public User login(String zhanghao,String password);
}
