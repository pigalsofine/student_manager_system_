package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.User;
import util.DBHelper;

public class UserDao {
	
	
	public User is_the_user(String username,String password) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		User user = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "select * from manager_user where username=? and Password=?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, username.toUpperCase());
			stmt.setString(2, password.toUpperCase());
			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			if (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				user = new User();
				user.setPassword(rs.getString("Password"));
				user.setUsername(rs.getString("username"));
				System.out.println(rs.getString("username")+" "+rs.getShort("Password"));
			}else {
				System.out.println("no");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
		}
		return user;
	}
	
	
	public static void main(String[] args) {
		try {
			UserDao userDao = new UserDao();
			User user = userDao.is_the_user("王娟", "1");
			if (user!=null) {
				System.out.println(user.getUsername()+" "+user.getPassword());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}

