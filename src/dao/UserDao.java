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
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		User user = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "select * from manager_user where username=? and Password=?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, username.toUpperCase());
			stmt.setString(2, password.toUpperCase());
			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			if (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
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
			//�ͷ����ݼ�����
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//�ͷ�������
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
			User user = userDao.is_the_user("����", "1");
			if (user!=null) {
				System.out.println(user.getUsername()+" "+user.getPassword());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}

