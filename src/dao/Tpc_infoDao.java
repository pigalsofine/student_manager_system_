package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Sc_Course;
import entity.Student_basic_info;
import entity.Tpc_info;
import util.DBHelper;

public class Tpc_infoDao {
	public ArrayList<Tpc_info> getTpc_infos(String sno,int grade){
		return null;
		/*Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_Award_Search ? ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());
			stmt.setInt(2, String.valueOf(grade).toUpperCase());
			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				sc_Course = new Sc_Course();
				sc_Course.setCno(rs.getString("cno"));
				sc_Course.setCname(rs.getString("cname"));
				sc_Course.setGrade(rs.getInt("grade"));
				sc_Course.setCcredit(rs.getDouble("ccredit"));
				sc_Course_list.add(sc_Course);
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
		return sc_Course_list;*/
	}
	//传入参数-班级号查询成绩
	public ArrayList<Tpc_info> getTpc_score_with_clsno(String clsno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec CN_GRADE_Search  ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, clsno.toUpperCase());
			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				tpc_info = new Tpc_info(); 
				tpc_info.setCname(rs.getString("cname"));
				tpc_info.setGrade(rs.getInt("grade"));
				tpc_info.setSno(rs.getString("sno"));
				tpc_info.setCno(rs.getString("cno"));
				tpc_info.setScore(rs.getInt("score"));
				tpc_info.setCcredit(rs.getDouble("CCREDIT"));
				tpc_info_list.add(tpc_info);
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
		return tpc_info_list;
	}
	//传入参数-专业、年级 查询教学计划
	public ArrayList<Tpc_info> getCoure(String SN,String grade ){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_Plan_Search  ?,?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, SN.toUpperCase());
			stmt.setString(2, grade.toUpperCase());
			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {

				//将获取到的用户信息给User，作为函数返回值
				tpc_info = new Tpc_info(); 
				tpc_info.setSpecialtyNo(rs.getString("specialtyNo"));
				tpc_info.setGrade(rs.getInt("grade"));
				tpc_info.setCno(rs.getString("cno"));
				tpc_info.setCname(rs.getString("cname"));
				tpc_info.setCcredit(rs.getDouble("CCREDIT"));
				tpc_info_list.add(tpc_info);
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
		return tpc_info_list;
	}
	//传入参数-专业号、年级 查询成绩
	public ArrayList<Tpc_info> getTpc_score_with_SpNO_and_Ga(String spno,String ga){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SpeNO_GRADE_Search  ? ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, spno.toUpperCase());
			stmt.setString(2, ga.toUpperCase());
			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				tpc_info = new Tpc_info(); 
				tpc_info.setGrade(rs.getInt("grade"));
				tpc_info.setSno(rs.getString("sno"));
				tpc_info.setCno(rs.getString("cno"));
				tpc_info.setScore(rs.getInt("score"));
				tpc_info.setCcredit(rs.getDouble("CCREDIT"));
				tpc_info_list.add(tpc_info);
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
		return tpc_info_list;
	}
	//传入参数-学号、课程号、新成绩 修改成绩
	public boolean change_score(String sno,String cno,int newG){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec  SNO_GRADE_Update  ?, ?, ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());
			stmt.setString(2, cno.toUpperCase());
			stmt.setInt(3, newG);
			//rs为返回结果
			stmt.executeQuery();
			
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
			Tpc_infoDao tpc_infoDao = new Tpc_infoDao();
			tpc_infoDao.change_score("S120001 ", "c001", 50);
			System.out.println("ok");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
