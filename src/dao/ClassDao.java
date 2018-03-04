package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Class_;
import entity.Student;
import util.DBHelper;

public class ClassDao {
	//传入参数-班级号查看班级信息：
	public ArrayList<Class_> getClass_accoding_clsno(String clsno) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Class_> class_list = new ArrayList<Class_>();
		Class_ class_ = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec ClassNO_Class_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, clsno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				class_ = new Class_();
				class_.setClsno(rs.getString("clsno"));
				class_.setClsname(rs.getString("clsname"));
				class_.setGrade(rs.getInt("grade"));
				class_.setTotal_class_num(rs.getInt("scount"));
				class_.setSpecialtyName(rs.getString("faculty"));
				class_.setDirector(rs.getString("director"));
				class_list.add(class_);
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
		return class_list;
	}
	//传入参数-专业名称查看班级信息
	public ArrayList<Class_> getClass_accoding_clsName(String clsname) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Class_> class_list = new ArrayList<Class_>();
		Class_ class_ = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SName_Class_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, clsname.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				class_ = new Class_();
				class_.setClsno(rs.getString("clsno"));
				class_.setClsname(rs.getString("clsname"));
				class_.setGrade(rs.getInt("grade"));
				class_.setTotal_class_num(rs.getInt("scount"));
				class_.setSpecialtyName(rs.getString("specialtyName"));
				class_.setFaculty(rs.getString("faculty"));
				class_.setDirector(rs.getString("director"));
				class_list.add(class_);
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
		return class_list;
	}
	//传入参数-院系查看班级信息
	public ArrayList<Class_> getClass_accoding_fa(String fa) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Class_> class_list = new ArrayList<Class_>();
		Class_ class_ = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec FA_Class_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, fa.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				class_ = new Class_();
				class_.setClsno(rs.getString("clsno"));
				class_.setClsname(rs.getString("clsname"));
				class_.setGrade(rs.getInt("grade"));
				class_.setTotal_class_num(rs.getInt("scount"));
				class_.setSpecialtyName(rs.getString("faculty"));
				class_.setDirector(rs.getString("director"));
				class_list.add(class_);
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
		return class_list;
	}
}
