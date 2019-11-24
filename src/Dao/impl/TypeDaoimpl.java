package Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.BaseDao;
import Dao.TypeDao;
import Dao.entity.Type;
/**
 * �������͵�ʵ����
 * @author �Ķ���
 *
 */
public class TypeDaoimpl implements TypeDao {
	/**
	 * �����������
	 */
	@Override
	public int addType(String typename) {
		String sql = "insert into type(typename) values(?)";
		
		return BaseDao.update(sql, new Object[]{typename});
	}
	/**
	 * �޸���������
	 */
	@Override
	public int updateType(Type type) {
		String sql = "update type set typename = ? where typeid = ?";
		
		return BaseDao.update(sql, new Object[]{type.getTypeid(),type.getTypename()});
	}
	/**
	 * ɾ����������
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
			//����Ϣ��ӵ�������
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
	 * ���ҵ�һ���͵�����������Ϣ
	 */
	@Override
	public Type findByName(String typename) {
		String sql = "select * from type where typename = ��";
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
