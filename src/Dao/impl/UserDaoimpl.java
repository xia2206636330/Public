package Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.BaseDao;
import Dao.UserDao;
import Dao.entity.User;
/**
 * 用户信息实现类
 * @author 夏冬旺
 *
 */
public class UserDaoimpl implements UserDao {
	/**
	 * 查找用户信息
	 */
	@Override
	public User login(String zhanghao, String password) {
		String sql = "select * from user where zhanghao = ? and password = ?";
		ResultSet rs  = BaseDao.query(sql, new Object[]{zhanghao,password });
		User u = null;
		try {
			while (rs.next()) {
				 u =new User();
				 u.setUserid(rs.getInt("userid"));
				 u.setZhanghao(rs.getString("zhanghao"));
				 u.setName(rs.getString("name"));
				 u.setZhuangtai(rs.getInt("zhuangtai"));
				 u.setShenfen(rs.getInt("shenfen"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
