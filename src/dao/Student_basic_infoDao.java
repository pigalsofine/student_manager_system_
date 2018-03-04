package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Student;
import entity.Student_basic_info;
import entity.User;
import util.DBHelper;

public class Student_basic_infoDao {
	
	public boolean is_student(String sno) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		int flag = 0;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "select * from student where sno=?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			if (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				flag = 1;
				System.out.println("is the student");
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
		if(1==flag){
			return true;
		}else {
			return false;
		}
		
	}
	
	//传入参数-学号查询个人信息
	public Student_basic_info getBasic_info(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		Student_basic_info student_basic_info = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_BaIn_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			if (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				student_basic_info = new Student_basic_info();
				student_basic_info.setSno(rs.getString("sno"));
				student_basic_info.setSname(rs.getString("sname"));
				student_basic_info.setSsex(rs.getString("ssex"));
				student_basic_info.setFaculty(rs.getString("faculty"));
				student_basic_info.setSpecialtyName(rs.getString("specialtyName"));
				student_basic_info.setClsname(rs.getString("clsname"));
				student_basic_info.setEnterYear(rs.getInt("enterYear"));
				student_basic_info.setRegister(rs.getInt("register"));
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
		return student_basic_info;
	}
	
	//获取学生注册信息
	public ArrayList<Student> getRegister_info(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Student> student_list = new ArrayList<Student>();
		Student student = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_BaIn_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				student = new Student();
				student.setRegister(rs.getInt("register"));
				student.setSname(rs.getString("sname"));
				student.setSno(rs.getString("sno"));
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
	
	//设置学生注册
	public boolean setRegister_info(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SN_REG_Update ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());

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
	//传入参数-班级号查询某个班级的全部学生（用于异动班级选择）
	public ArrayList<Student> getStudent_accoding_clsno(String clsno) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Student> student_list = new ArrayList<Student>();
		Student student = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec CLSNO_STU_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, clsno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				student = new Student();
				student.setSname(rs.getString("sname"));
				student.setSno(rs.getString("sno"));
				student.setClsNO(rs.getString("clsno"));
				student.setSsex(rs.getString("ssex"));
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
	//用于异动。
	public boolean change_classNo(String sno,String newclsno) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec CLSNO_STU_Change ? , ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			System.out.println(sno+" "+newclsno);
			
			System.out.println("异动");
			stmt.setString(1, sno.toUpperCase());
			stmt.setString(2, newclsno.toUpperCase());
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
	//传入参数-班级号查询某个班级的全部学生（用于异动班级选择）
	public ArrayList<Student> getStudent_accoding_specialtyNo(String specialtyNo) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Student> student_list = new ArrayList<Student>();
		Student student = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec  SN_REG_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, specialtyNo.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				student = new Student();
				student.setSname(rs.getString("sname"));
				student.setSno(rs.getString("sno"));
				student.setRegister(rs.getInt("register"));
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
	//删除学生
	public boolean delete_student(String sno) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec  SNO_Delete ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());

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
	
	public static void main(String[] args) {
		try {
			Student_basic_infoDao studentDaoBasic_infoDao = new Student_basic_infoDao();
			Student_basic_info student_basic_info = studentDaoBasic_infoDao.getBasic_info("s120001");
			System.out.println(student_basic_info.print());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}


