package Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.BaseDao;
import Dao.TypeDao;
import Dao.entity.Type;
/**
 * 新闻类型的实现类
 * @author 夏冬旺
 *
 */
public class TypeDaoimpl implements TypeDao {
	/**
	 * 添加新闻类型
	 */
	@Override
	public int addType(String typename) {
		String sql = "insert into type(typename) values(?)";
		
		return BaseDao.update(sql, new Object[]{typename});
	}
	/**
	 * 修改新闻类型
	 */
	@Override
	public int updateType(Type type) {
		String sql = "update type set typename = ? where typeid = ?";
		
		return BaseDao.update(sql, new Object[]{type.getTypeid(),type.getTypename()});
	}
	/**
	 * 删除新闻类型
	 */
	@Override
	public int daleteType(int typeid) {
		String sql = "delete from type where typeid = ?";
		return BaseDao.update(sql, new Object[]{typeid});
	}

	@Override
	public List<Type> findAll() {
		String sql = "select * from type";
		ResultSet rs = BaseDao.query(sql, null);
		List<Type> types = new ArrayList<Type>();
		
		try {
			while(rs.next()){
				Type t = new Type();
			t.setTypeid(rs.getInt("typeid"));
			t.setTypename(rs.getString("typename"));
			//把信息添加到集合中
			types.add(t);
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}finally{
			try {
				BaseDao.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		
		return types;
	}
	/**
	 * 查找单一类型的新闻类型信息
	 */
	@Override
	public Type findByName(String typename) {
		String sql = "select * from type where typename = ？";
		ResultSet rs = BaseDao.query(sql, new Object[]{typename});
		Type t = null;
		try {
			if(rs.next()){
			 t = new Type();
			t.setTypeid(rs.getInt("typeid"));
			t.setTypename(rs.getString("typename"));			
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			try {
				BaseDao.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		
		return t;
	}

}
