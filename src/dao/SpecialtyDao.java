package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Class_;
import entity.Specialty;
import entity.Student_basic_info;
import util.DBHelper;

public class SpecialtyDao {
	
	public ArrayList<Specialty> getAllFA() {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Specialty> specialty_list = new ArrayList<Specialty>();
		Specialty specialty = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec Faculty_Search";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			
			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				specialty = new Specialty();
				specialty.setFaculty(rs.getString("faculty"));
				specialty_list.add(specialty);
				System.out.println(rs.getString("faculty"));
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
		return specialty_list;
	}
	
	public ArrayList<Specialty> getSpe_accoding_fa(String fa) {
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Specialty> specialty_list = new ArrayList<Specialty>();
		Specialty specialty = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec FA_Spe_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, fa.toUpperCase());
			
			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				specialty = new Specialty();
				specialty.setSpecialtyName(rs.getString("specialtyName"));
				specialty.setSpecialtyNo(rs.getString("specialtyNo"));
				specialty_list.add(specialty);
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
		return specialty_list;
	}
	
	public static void main(String[] args) {
		try {
			SpecialtyDao specialtyDao = new SpecialtyDao();
			ArrayList<Specialty> specialty_list = specialtyDao.getSpe_accoding_fa("信息工程系");
			for (int i = 0; i < specialty_list.size(); i++) {
				System.out.println(specialty_list.get(i).getSpecialtyName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
