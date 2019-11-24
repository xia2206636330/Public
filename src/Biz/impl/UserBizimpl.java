package Biz.impl;

import Biz.UserBiz;
import Dao.UserDao;
import Dao.entity.User;
import Dao.impl.UserDaoimpl;
/**
 *    新闻用户实现类
 * @author 夏冬旺
 *
 */
public class UserBizimpl implements UserBiz {

	@Override
	public User login(String zhanghao, String password) {
		UserDao ud = new UserDaoimpl();
		return ud.login(zhanghao, password);
	}

}
