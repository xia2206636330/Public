package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ��װ�������ݿ⣬�������ݿ����������
 * @author mxl
 * @version 1.0
 *
 */
public class BaseDao {
	private static String url ="";
	private static String driver ="";
	private static String uname ="";
	private static String upwd ="";
	
	
	private static Connection con= null;
	private static PreparedStatement st =null;
	private static ResultSet  rs = null;
	//��̬�����
	static{
		try {
			
			//��ȡ�����ļ�
			Properties pro = new Properties();
			InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("Dao/db.properties");
			pro.load(is);
			
			url = pro.getProperty("url");
			driver = pro.getProperty("driver");
			uname = pro.getProperty("uname");
			upwd = pro.getProperty("upwd");
			
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡ���Ӷ���
	 * @return  Connection
	 */
	public static Connection getConnection(){
		try {
			con = DriverManager.getConnection(url,uname ,upwd );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * ������ɾ�ĵ�ͨ�÷���
	 * @param sql  SQL���
	 * @param params  ������
	 * @return  Ӱ������
	 */
	public static int update(String sql,Object[] params){
		int result = 0;
		try {
			st =getConnection().prepareStatement(sql);//insert into b values(?,?,?)
			if(params!=null && params.length>0){
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
			}
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return result;
	}
	
	/**
	 * ���ڲ�ѯ�ķ���
	 * @param sql
	 * @param params
	 * @return  ���
	 */
	public static ResultSet query(String sql,Object[] params){
		try {
			st =getConnection().prepareStatement(sql);
			if(params!=null && params.length>0){
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
			}
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * �ͷ���Դ�ķ���
	 */
	public  static void close(){
		try {
			if(rs!=null){
				rs.close();
			}
			
			if(st!=null){
				st.close();
			}
			
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
