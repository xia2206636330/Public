package Biz;

import Dao.entity.User;

/**
 *  ҵ���߼���  �����û��ӿ�
 * @author �Ķ���
 *
 */
public interface UserBiz {
	/**
	 * ��ѯ�û�
	 * @param zhanghao
	 * @param password
	 * @return
	 */
	public User login(String zhanghao, String password);
}
