package Biz.impl;

import Biz.UserBiz;
import Dao.UserDao;
import Dao.entity.User;
import Dao.impl.UserDaoimpl;
/**
 *    �����û�ʵ����
 * @author �Ķ���
 *
 */
public class UserBizimpl implements UserBiz {

	@Override
	public User login(String zhanghao, String password) {
		UserDao ud = new UserDaoimpl();
		return ud.login(zhanghao, password);
	}

}
