package Dao;

import java.util.List;

import Dao.entity.Type;



/**
 * �����������ݷ��ʲ�ӿ�
 * @author �Ķ���
 *
 */
public interface TypeDao {
	/**
	 * ��������
	 */
	public int addType(String typename);
	
	
	/**
	 * �޸�����
	 */
	public int updateType(Type type);
	
	
	/**
	 * ɾ���ӿ�
	 */
	public int daleteType(int typeid);
	
	/**
	 * ��ȡ���е�����������Ϣ
	 */
	public List<Type> findAll();
	
	
	/**
	 * ������������ѯ������������
	 */
	public Type findByName(String typename);
}
