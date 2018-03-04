package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Check_up;
import entity.Student;
import entity.Student_basic_info;
import util.DBHelper;

public class Check_upDao {
	public Check_up getCheck_up_info_with_sno(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		Check_up check_up = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_ChUp_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			if (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				check_up = new Check_up();
				check_up.setSno(rs.getString("sno"));
				check_up.setHeight(rs.getDouble("height"));
				check_up.setWeight(rs.getDouble("weight"));
				check_up.setTvc(rs.getInt("tvc"));
			}else {
				System.out.println("没有该用户");
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
		return check_up;
	}
	//传入参数-专业号查询体检情况
	public ArrayList<Check_up> getCheck_up_info_with_spno(String spno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Check_up> check_up_list = new ArrayList<Check_up>();
		Check_up check_up = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SpeNO_CU_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, spno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				check_up = new Check_up();
				check_up.setSno(rs.getString("sno"));
				check_up.setHeight(rs.getDouble("height"));
				check_up.setWeight(rs.getDouble("weight"));
				check_up.setTvc(rs.getInt("tvc"));
				check_up_list.add(check_up);
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
		return check_up_list;
	}

	//传入参数-学号、身高、体重、肺活量 添加体检信息
	public boolean add_punishment_info(String sno,int h,int w,int tvc){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_CU_Insert ?, ? ,? ,?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());
			stmt.setInt(2, h);
			stmt.setInt(3, w);
			stmt.setInt(4, tvc);

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
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
		return true;
	}
		
	
	public ArrayList<Student> get_Nocheck_student(String spNO){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Student> student_list = new ArrayList<Student>();
		Student student = new Student();
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SpeNO_NCU_Count ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, spNO.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				student = new Student();
				student.setSno(rs.getString("sno"));
				student.setSname(rs.getString("sname"));
				student.setClsNO(rs.getString("clsno"));
				student_list.add(student);
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
		return student_list;
	}
	
	public static void main(String[] args) {
		try {
			Check_upDao check_up_dao = new Check_upDao();
			Check_up check_up = check_up_dao.getCheck_up_info_with_sno("s120001");
			System.out.println(check_up.print());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
