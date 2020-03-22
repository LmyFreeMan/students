package com.lizhou.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//ThreadLocal可以为每个线程复制一个副本， 也叫线程本地便量
public class MysqlTool {
	private static ComboPooledDataSource dataSource = null;

	
	static {
		//连接池的对象
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	public static Connection getConnection(){
		Connection conn = tl.get();//先取变量  获取tl中的变量，如果不够，会自动创建副本
		try {
			if(conn == null){//第一次拿，判空，如果没了，就创建一个连接
				conn = dataSource.getConnection();//创建一个连接，数据源拿链接
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		tl.set(conn);  //有了连接就放进去一个
		return conn;
	}
	
	
	// 开始事务 自动变手工，即为开启事务
	
	public static void beginTransaction(){
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);//setAutoCommit 自动提交，false即为手工提交
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 提交事务
	
	public static void commit(){
		Connection conn = getConnection();
		try {
			if(conn !=null) {
			conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//回滚事务
		public static void rollback(){
		Connection conn = getConnection();
		try {
			if(conn !=null) {
			conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 关闭Connection,并移除线程中的连接
	 */
	public static void closeConnection(){
		Connection conn = getConnection();
		
		close(getConnection());
		tl.remove();
	}
	
	public static void close(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stm){
		try {
			if(stm != null){
				stm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
