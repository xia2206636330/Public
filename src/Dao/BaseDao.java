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
 * 封装连接数据库，进行数据库操作工具类
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
	//静态代码块
	static{
		try {
			
			//读取配置文件
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
			System.out.println("驱动类错误");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接对象
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
	 * 用于增删改的通用方法
	 * @param sql  SQL语句
	 * @param params  参数集
	 * @return  影响行数
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
	 * 用于查询的方法
	 * @param sql
	 * @param params
	 * @return  结果
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
	 * 释放资源的方法
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
